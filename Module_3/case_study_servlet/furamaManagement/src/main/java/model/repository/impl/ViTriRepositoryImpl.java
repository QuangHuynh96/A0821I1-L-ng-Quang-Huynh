package model.repository.impl;

import model.bean.ViTri;
import model.repository.BaseRepository;
import model.repository.ViTriRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViTriRepositoryImpl implements ViTriRepository {
    private  static  final String FIND_ALL = "select * from vi_tri where  delete_flag = true;";
    @Override
    public List<ViTri> findAll() {
        List<ViTri> viTriList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                ViTri viTri = new ViTri(id, ten);
                viTriList.add(viTri);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return viTriList;
    }
}
