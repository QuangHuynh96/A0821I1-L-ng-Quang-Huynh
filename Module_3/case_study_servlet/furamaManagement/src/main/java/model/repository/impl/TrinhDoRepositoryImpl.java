package model.repository.impl;

import model.bean.TrinhDo;
import model.repository.BaseRepository;
import model.repository.TrinhDoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoRepositoryImpl implements TrinhDoRepository {
        private static final String FIND_ALL = "select * from trinh_do where  delete_flag = true;";
    @Override
    public List<TrinhDo> findAll() {
        List<TrinhDo> trinhDoList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String ten = resultSet.getString(2);
            TrinhDo trinhDo = new TrinhDo(id, ten);
            trinhDoList.add(trinhDo);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trinhDoList;
    }
}
