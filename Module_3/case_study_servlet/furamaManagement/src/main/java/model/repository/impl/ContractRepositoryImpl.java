package model.repository.impl;

import model.bean.HopDong;
import model.repository.BaseRepository;
import model.repository.ContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private static final String FINDALL = "select * from hop_dong where delete_flag = true;";
    private static final String ADDNEW = "insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc)" +
            "values (?,?,?,?,?,?);";
    private  static final String DELETE = "update hop_dong set delete_flag = false where id = ?;";
    @Override
    public List<HopDong> findAll() {
        List<HopDong> hopDongList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                int idNhanVien = resultSet.getInt(2);
                int idKhachHang = resultSet.getInt(3);
                int idDichVu = resultSet.getInt(4);
                String ngayLamHopDong = resultSet.getString(5);
                String ngayKetThuc = resultSet.getString(6);
                Double tienDatCoc = resultSet.getDouble(7);
                HopDong hopDong = new HopDong(id, idNhanVien, idKhachHang, idDichVu, ngayLamHopDong, ngayKetThuc, tienDatCoc);
                hopDongList.add(hopDong);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hopDongList;
    }

    @Override
    public boolean save(HopDong hopDong) {
        boolean check = false;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADDNEW);
            preparedStatement.setInt(1, hopDong.getIdNhanVien());
            preparedStatement.setInt(2, hopDong.getIdKhachHang());
            preparedStatement.setInt(3, hopDong.getIdDichVu());
            preparedStatement.setString(4, hopDong.getNgayLamHopDong());
            preparedStatement.setString(5, hopDong.getNgayKetThuc());
            preparedStatement.setDouble(6, hopDong.getTienDatCoc());
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                check = true;
            }
        } catch (SQLException throwables) {
            return false;
        }
        return check;
    }

    @Override
    public boolean update(int id, HopDong hopDong) {
        return false;
    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<HopDong> FindByName(String name) {
        return null;
    }

    @Override
    public HopDong FindById(int id) {
        return null;
    }
}
