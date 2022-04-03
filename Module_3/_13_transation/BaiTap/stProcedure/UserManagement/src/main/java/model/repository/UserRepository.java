package model.repository;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    public void insertUser(User user) throws SQLException;
    public User findById(int id);
    public List<User> selectUsers();
    public List<User> selectUsers(String sort);

    public boolean deleteUser(int id) throws SQLException;
    public boolean updDateUser(User user) throws SQLException;
    public List<User> findByCountry(String country);
    //ss_13
    public User getUserById(int id);
    public  User insertUserStore(User user);
    void addUserTransaction(User user, int[] permision);

}
