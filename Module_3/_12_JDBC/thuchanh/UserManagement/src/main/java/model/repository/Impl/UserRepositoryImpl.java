package model.repository.Impl;

import model.bean.User;
import model.repository.BaseRepository;
import model.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final String FIND_BY_ALL = "select * from users;";

    private static final String SOFT_ASC = "select * from users\n" +
            " order by name asc;";
    private static final String SOFT_DESC = "select * from users\n" +
            " order by name desc;";

    private static final String ADD_NEW= "insert into users(`name`, email, country)\n" +
            "values (?,?,?);";
    private static final String DELETE = "delete from users \n" +
            "where id = ?;";
    private static final String FIND_BY_ID = "select * from users\n" +
            "where id = ?;";
    private static final String UPDATE_USER = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String FIND_BY_COUNTRY = "select * from users\n" +
            "where country = ?;";
    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();
            // trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                String name  = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id"); // colummLable : tên thuoc tính của bảng
                String name  = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> selectUsers(String sort) {
        List<User> sortUserList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement;
            if (sort.equals("asc")) {
                 preparedStatement = connection.prepareStatement(SOFT_ASC);
            }else {
                 preparedStatement = connection.prepareStatement(SOFT_DESC);
            }
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                sortUserList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sortUserList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            int check = preparedStatement.executeUpdate();
            if(check != 0) {
                return  true;
            }
            // trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updDateUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
            // trả về số lương record bị ảnh hưởng ( thếm mới thành công  =1)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findByCountry(String countryIn) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY);
            preparedStatement.setString(1,countryIn);
            System.out.println(preparedStatement);

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                 userList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
