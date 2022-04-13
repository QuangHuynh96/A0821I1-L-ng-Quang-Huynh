package model.repository.impl;

import model.bean.Customer;
import model.bean.Employees;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String FIND_BY_ALL = "select * from nhan_vien where delete_flag = true;";
    private static final String ADD_NEW_EMPLOYEE =
            "insert into nhan_vien(ten, ngay_sinh, cmnd, luong, so_dien_thoai, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan)\n" +
                    "values \t(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private  static final String DELETE_EMPLOYEE = "update nhan_vien set delete_flag = false where id = ?;";
    private static final String UPDATE_EMPLOYEE =
            "update nhan_vien set ten= ?, ngay_sinh =?, cmnd =?, luong = ?, so_dien_thoai =?, email =?, dia_chi =?, id_vi_tri = ?, id_trinh_do = ?, id_bo_phan = ? where id = ?;";
    private static final String FINDBYID = "select * from nhan_vien where id = ? and  delete_flag = true;";
    private static final String FINDBYNAME = "select * from nhan_vien where ten like ? and  delete_flag = true;";

    @Override
    public List<Employees> findAll() {
        List<Employees> employeesList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                String ngaySinh = resultSet.getString(3);
                int cmnd = resultSet.getInt(4);
                int luong = resultSet.getInt(5);
                int soDienThoai = resultSet.getInt(6);
                String email = resultSet.getString(7);
                String diaChi = resultSet.getString(8);
                int idViTri = resultSet.getInt(9);
                int idTrinhDo = resultSet.getInt(10);
                int idBoPhan = resultSet.getInt(11);
                Employees employees = new Employees(id,ten,ngaySinh, cmnd, luong, soDienThoai,email,diaChi,idViTri,idTrinhDo,idBoPhan);
                employeesList.add(employees);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesList;
    }

    @Override
    public boolean save(Employees employees) {
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_EMPLOYEE);
            preparedStatement.setString(1, employees.getTen());
            preparedStatement.setString(2, employees.getNgaySinh());
            preparedStatement.setInt(3, employees.getCmnd());
            preparedStatement.setInt(4,employees.getLuong());
            preparedStatement.setInt(5, employees.getSoDienThoai());
            preparedStatement.setString(6, employees.getEmail());
            preparedStatement.setString(7, employees.getDiaChi());
            preparedStatement.setInt(8,employees.getIdViTri());
            preparedStatement.setInt(9,employees.getIdTrinhDo());
            preparedStatement.setInt(10,employees.getIdBoPhan());
            int costs = preparedStatement.executeUpdate();
            if(costs == 1) {
                check = true;
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(int id, Employees employees) {
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employees.getTen());
            preparedStatement.setString(2, employees.getNgaySinh());
            preparedStatement.setInt(3, employees.getCmnd());
            preparedStatement.setInt(4,employees.getLuong());
            preparedStatement.setInt(5, employees.getSoDienThoai());
            preparedStatement.setString(6, employees.getEmail());
            preparedStatement.setString(7, employees.getDiaChi());
            preparedStatement.setInt(8,employees.getIdViTri());
            preparedStatement.setInt(9,employees.getIdTrinhDo());
            preparedStatement.setInt(10,employees.getIdBoPhan());
            preparedStatement.setInt(11, id);
            int costs = preparedStatement.executeUpdate();
            if(costs == 1) {
                check = true;
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.executeUpdate());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employees> FindByName(String name) {
        List<Employees> employeesList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);

            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                String ngaySinh = resultSet.getString(3);
                int cmnd = resultSet.getInt(4);
                int luong = resultSet.getInt(5);
                int soDienThoai = resultSet.getInt(6);
                String email = resultSet.getString(7);
                String diaChi = resultSet.getString(8);
                int idViTri = resultSet.getInt(9);
                int idTrinhDo = resultSet.getInt(10);
                int idBoPhan = resultSet.getInt(11);
                Employees employees = new Employees(id,ten,ngaySinh, cmnd, luong, soDienThoai,email,diaChi,idViTri,idTrinhDo,idBoPhan);
                employeesList.add(employees);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesList;
    }

    @Override
    public Employees FindById(int id) {
        Employees employees = null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ten = resultSet.getString(2);
                String ngaySinh = resultSet.getString(3);
                int cmnd = resultSet.getInt(4);
                int luong = resultSet.getInt(5);
                int soDienThoai = resultSet.getInt(6);
                String email = resultSet.getString(7);
                String diaChi = resultSet.getString(8);
                int idViTri = resultSet.getInt(9);
                int idTrinhDo = resultSet.getInt(10);
                int idBoPhan = resultSet.getInt(11);
                employees = new Employees(id,ten,ngaySinh, cmnd, luong, soDienThoai,email,diaChi,idViTri,idTrinhDo,idBoPhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }
}
