package model.repository.impl;

import model.bean.HopDongChiTiet;
import model.repository.BaseRepository;
import model.repository.ContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    private static final String FINDALL = "select * from hop_dong_chi_tiet where delete_flag = true;";
    private static final String ADDNEW = "insert into hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong)" +
            "values (?, ?, ?);";
    @Override
    public List<HopDongChiTiet> findAll() {
        return null;
    }

    @Override
    public boolean save(HopDongChiTiet hopDongChiTiet) {
        boolean check = false;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADDNEW);
            preparedStatement.setInt(1, hopDongChiTiet.getIdHopDong());
            preparedStatement.setInt(2, hopDongChiTiet.getIdDichVuDiKem());
            preparedStatement.setInt(3, hopDongChiTiet.getSoLuong());
            int count = preparedStatement.executeUpdate();
            if(count >0) {
                check = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(int id, HopDongChiTiet hopDongChiTiet) {
        return false;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<HopDongChiTiet> FindByName(String name) {
        return null;
    }

    @Override
    public HopDongChiTiet FindById(int id) {
        return null;
    }
}
