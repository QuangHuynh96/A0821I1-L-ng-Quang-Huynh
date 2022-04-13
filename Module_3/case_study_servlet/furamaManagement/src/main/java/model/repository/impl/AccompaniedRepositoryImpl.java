package model.repository.impl;

import model.bean.DichVuDiKem;
import model.repository.AccompaniedRepository;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AccompaniedRepositoryImpl implements AccompaniedRepository {
    private static final String FINDALL = "select * from dich_vu_di_kem where delete_flag = true";
    @Override
    public List<DichVuDiKem> findAll() {
        List<DichVuDiKem> dichVuDiKemList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                int gia = resultSet.getInt(3);
                String donVi = resultSet.getString(4);
                String trangThai = resultSet.getString(5);
                DichVuDiKem dichVuDiKem = new DichVuDiKem(id, ten, gia,donVi,trangThai);
                dichVuDiKemList.add(dichVuDiKem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVuDiKemList;
    }
}
