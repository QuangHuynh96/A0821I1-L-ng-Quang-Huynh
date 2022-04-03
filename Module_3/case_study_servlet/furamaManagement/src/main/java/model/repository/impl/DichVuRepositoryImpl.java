package model.repository.impl;

import model.bean.DichVu;
import model.repository.BaseRepository;
import model.repository.DichVuRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuRepositoryImpl implements DichVuRepository {
    private static final String FIND_BY_ALL = "select * from dich_vu;";
    private static final String ADD_NEW_DICHVU =
            "insert into dich_vu("
                    +"id_kieu_thue," +
                    " id_loai_dich_vu," +
                    " ten," +
                    " dien_tich," +
                    " chi_phi_thue," +
                    " so_nguoi_toi_da," +
                    " tieu_chuan_phong," +
                    " mo_ta_tien_nghi_khac," +
                    " dien_tich_ho_boi," +
                    " so_tang)\n"
                    + "values \t(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private  static final String DELETE_DICHVU = "delete from dich_vu where id = ?;";
    private static final String UPDATE_DICHVU =
            "update dich_vu set" +
                    " id_kieu_thue = ?," +
                    " id_loai_dich_vu = ?," +
                    " ten = ?," +
                    " dien_tich = ?," +
                    " chi_phi_thue = ?," +
                    " so_nguoi_toi_da = ?," +
                    " tieu_chuan_phong = ?," +
                    " mo_ta_tien_nghi_khac = ?," +
                    " dien_tich_ho_boi = ?," +
                    " so_tang = ?" +
                    " where id = ?;";
    private static final String FINDBYID = "select * from dich_vu where id = ?;";
    private static final String FINDBYNAME = "select * from dich_vu where ten like ?;";

    @Override
    public List<DichVu> findAll() {
        List<DichVu> dichVuList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                int idKieuthue = resultSet.getInt(2);
                int idLoaiDichVu = resultSet.getInt(3);
                String ten = resultSet.getString(4);
                int dienTich = resultSet.getInt(5);
                double chiPhiThue = resultSet.getDouble(6);
                int soNguoiToiDa = resultSet.getInt(7);
                String tieuChuanPhong = resultSet.getString(8);
                String moTaTienNghiKhac = resultSet.getString(9);
                int dienTichHoBoi = resultSet.getInt(10);
                int soTang = resultSet.getInt(11);

                DichVu dichVu = new DichVu(id, idKieuthue, idLoaiDichVu, ten, dienTich, chiPhiThue, soNguoiToiDa, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi,soTang);
                dichVuList.add(dichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVuList;
    }

    @Override
    public void save(DichVu dichVu) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_DICHVU);
            preparedStatement.setInt(1, dichVu.getIdKieuThue());
            preparedStatement.setInt(2, dichVu.getIdLoaiDichVu());
            preparedStatement.setString(3, dichVu.getTen());
            preparedStatement.setInt(4, dichVu.getDienTich());
            preparedStatement.setDouble(5, dichVu.getChiPhiThue());
            preparedStatement.setInt(6, dichVu.getSoNguoiToiDa());
            preparedStatement.setString(7, dichVu.getTieuChuanPhong());
            preparedStatement.setString(8, dichVu.getMoTaTienNghiKhac());
            preparedStatement.setInt(9,dichVu.getDienTichHoBoi());
            preparedStatement.setInt(10,dichVu.getSoTang());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int id, DichVu dichVu) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DICHVU);

            preparedStatement.setInt(1, dichVu.getIdKieuThue());
            preparedStatement.setInt(2, dichVu.getIdLoaiDichVu());
            preparedStatement.setString(3, dichVu.getTen());
            preparedStatement.setInt(4, dichVu.getDienTich());
            preparedStatement.setDouble(5, dichVu.getChiPhiThue());
            preparedStatement.setInt(6, dichVu.getSoNguoiToiDa());
            preparedStatement.setString(7, dichVu.getTieuChuanPhong());
            preparedStatement.setString(8, dichVu.getMoTaTienNghiKhac());
            preparedStatement.setInt(9,dichVu.getDienTichHoBoi());
            preparedStatement.setInt(10,dichVu.getSoTang());
            preparedStatement.setInt(11, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DICHVU);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<DichVu> FindByName(String name) {
        List<DichVu> dichVuList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);
            preparedStatement.setString(1,'%'+name+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idKieuthue = resultSet.getInt(2);
                int idLoaiDichVu = resultSet.getInt(3);
                String ten = resultSet.getString(4);
                int dienTich = resultSet.getInt(5);
                double chiPhiThue = resultSet.getDouble(6);
                int soNguoiToiDa = resultSet.getInt(7);
                String tieuChuanPhong = resultSet.getString(8);
                String moTaTienNghiKhac = resultSet.getString(9);
                int dienTichHoBoi = resultSet.getInt(10);
                int soTang = resultSet.getInt(11);

                DichVu dichVu = new DichVu(id, idKieuthue, idLoaiDichVu, ten, dienTich, chiPhiThue, soNguoiToiDa, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi,soTang);
                dichVuList.add(dichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVuList;
    }

    @Override
    public DichVu FindById(int id) {
        Connection connection = BaseRepository.getConnect();
        DichVu dichVu = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDichVu = resultSet.getInt(1);
                int idKieuthue = resultSet.getInt(2);
                int idLoaiDichVu = resultSet.getInt(3);
                String ten = resultSet.getString(4);
                int dienTich = resultSet.getInt(5);
                double chiPhiThue = resultSet.getDouble(6);
                int soNguoiToiDa = resultSet.getInt(7);
                String tieuChuanPhong = resultSet.getString(8);
                String moTaTienNghiKhac = resultSet.getString(9);
                int dienTichHoBoi = resultSet.getInt(10);
                int soTang = resultSet.getInt(11);
                dichVu = new DichVu(idDichVu, idKieuthue, idLoaiDichVu, ten, dienTich, chiPhiThue, soNguoiToiDa, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVu;
    }
}
