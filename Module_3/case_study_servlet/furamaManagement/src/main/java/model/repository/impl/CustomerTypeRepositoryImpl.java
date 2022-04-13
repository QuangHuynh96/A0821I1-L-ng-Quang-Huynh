package model.repository.impl;

import model.bean.Customer;
import model.bean.LoaiKhach;
import model.repository.BaseRepository;
import model.repository.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    private static  final String FIND_ALL = "select * from loai_khach where delete_flag = true;";
    @Override
    public List<LoaiKhach> findAll() {
        List<LoaiKhach> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");

                LoaiKhach loaiKhach = new LoaiKhach(id, ten);
                customerTypeList.add(loaiKhach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerTypeList;
    }

    @Override
    public void save(LoaiKhach loaiKhach) {

    }

    @Override
    public void update(int id, LoaiKhach loaiKhach) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Customer FindByName(String name) {
        return null;
    }
}
