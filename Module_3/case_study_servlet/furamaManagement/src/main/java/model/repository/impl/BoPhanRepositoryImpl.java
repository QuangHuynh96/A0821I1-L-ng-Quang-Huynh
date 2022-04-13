package model.repository.impl;

import model.bean.BoPhan;
import model.repository.BaseRepository;
import model.repository.BoPhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoPhanRepositoryImpl implements BoPhanRepository {
    private static final String FIND_ALL = "select * from bo_phan where delete_flag = true;";
    @Override
    public List<BoPhan> findAll() {
        List<BoPhan> boPhanList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                BoPhan boPhan = new BoPhan(id , ten);
                boPhanList.add(boPhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return boPhanList;
    }
}
