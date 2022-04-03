package model.repository.impl;

import model.bean.KieuThue;
import model.bean.LoaiKhach;
import model.repository.BaseRepository;
import model.repository.RentalTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalTypeDAOImpl implements RentalTypeDAO {
    private static final String FINDALL = "select * from kieu_thue;";
    @Override
    public List<KieuThue> findAll() {
        List<KieuThue> kieuThueList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten");
                KieuThue kieuThue = new KieuThue(id, name);
                kieuThueList.add(kieuThue);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kieuThueList;
    }
}
