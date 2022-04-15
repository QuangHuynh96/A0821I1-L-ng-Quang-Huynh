package model.repository.impl;

import model.bean.Auther;
import model.bean.Book;
import model.repository.AutherRepository;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutherRepositoryImpl implements AutherRepository {
    private static final String FINDALL = "select * from auther where delete_flag = true;";
    private static final String FINDBYID = "select * from auther where delete_flag = true and id_author = ?;";
    private static final String ADDNEW = "insert into Auther (`name`, nick_name, address)\n" +
            "values (?, ?, ?);";
    private static final String DELETE = "update auther set delete_flag = false where id_author = ?;";
    private static final String UPDATE = "update auther set `name` = ?, nick_name = ?, address = ?  where id_author = ? and delete_flag = true;";
    private static final String SEARCH ="select * from auther\n" +
            "where name like ? and nick_name like ? and address like ? and delete_flag = true;";
    @Override
    public List<Auther> findAll() {
        List<Auther> autherList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String nickName = resultSet.getString(3);
                String address = resultSet.getString(4);
                Auther auther = new Auther(id,name, nickName, address);
                autherList.add(auther);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autherList;
    }

    @Override
    public boolean add(Auther auther) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADDNEW);
            preparedStatement.setString(1,auther.getName());
            preparedStatement.setString(2,auther.getNickName());
            preparedStatement.setString(3,auther.getAddress());
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Auther auther) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,auther.getName());
            preparedStatement.setString(2,auther.getNickName());
            preparedStatement.setString(3,auther.getAddress());
            preparedStatement.setInt(4,auther.getId());
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            int check = preparedStatement.executeUpdate();// trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Auther> search(String name, String nickName, String address) {
        List<Auther> autherList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+nickName+"%");
            preparedStatement.setString(3,"%"+address+"%");

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String newName = resultSet.getString(2);
                String newNickName = resultSet.getString(3);
                String newAddress = resultSet.getString(4);
                Auther auther = new Auther(id, newName, newNickName, newAddress);
                autherList.add(auther);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autherList;
    }

    @Override
    public Auther findById(int id) {
        Auther auther = null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String nickName = resultSet.getString(3);
                String address = resultSet.getString(4);
                auther = new Auther(id,name, nickName, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return auther;
    }
}
