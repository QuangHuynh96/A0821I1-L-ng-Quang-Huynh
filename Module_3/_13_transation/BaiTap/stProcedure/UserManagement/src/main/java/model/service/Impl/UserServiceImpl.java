package model.service.Impl;

import model.bean.User;
import model.repository.Impl.UserRepositoryImpl;
import model.repository.UserRepository;
import model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> selectUsers() {
        return userRepository.selectUsers();
    }

    @Override
    public List<User> selectUsers(String sort) {
        return userRepository.selectUsers(sort);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updDateUser(User user) throws SQLException {
        return userRepository.updDateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user)  {
        try {
            userRepository.insertUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
