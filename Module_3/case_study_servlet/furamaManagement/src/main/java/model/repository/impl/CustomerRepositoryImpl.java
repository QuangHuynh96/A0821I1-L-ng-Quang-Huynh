package model.repository.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String FIND_BY_ALL = "select * from khach_hang;";
    private static final String ADD_NEW_CUSTOMER =
            "insert into khach_hang(id_loai_khach, ten, ngay_sinh, gioi_tinh, cmnd, so_dien_thoai, email, dia_chi)\n" +
            "values \t(?, ?, ?, ?, ?, ?, ?, ?);";
    private  static final String DELETE_CUSTOMER = "delete from khach_hang where id = ?;";
    private static final String UPDATE_CUSTOMER =
            "update khach_hang set id_loai_khach = ?,ten= ?, ngay_sinh =?, gioi_tinh =?, cmnd =?, so_dien_thoai =?, email =?, dia_chi =? where id = ?;";
    private static final String FINDBYID = "select * from khach_hang where id = ?;";
    private static final String FINDBYNAME = "select * from khach_hang where ten like ?;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);

            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idLoaiKhach = resultSet.getInt("id_loai_khach");
                String ten = resultSet.getString("ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                boolean gioiTinh = false;
                String gioi_tinh= resultSet.getString("gioi_tinh");
                if(gioi_tinh.equals("1")) {
                    gioiTinh = true;
                }
                int idCard = resultSet.getInt("cmnd");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");

                Customer customer = new Customer(id,idLoaiKhach, ten, ngaySinh, gioiTinh, idCard, soDienThoai, email, diaChi);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = BaseRepository.getConnect();

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(ADD_NEW_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdLoaikhach());
            preparedStatement.setString(2, customer.getTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            if(customer.isGioiTinh()) {
                preparedStatement.setInt(4, 1);
            }else {
                preparedStatement.setInt(4, 0);
            }
            preparedStatement.setInt(5,customer.getCmnd());
            preparedStatement.setInt(6,customer.getSoDienThoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDiaChi());

            preparedStatement.executeUpdate();//update tra ve so luong record bi anh huong.

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int id, Customer customer) {
        Connection connection = BaseRepository.getConnect();

        try {
            PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdLoaikhach());
            preparedStatement.setString(2, customer.getTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            if(customer.isGioiTinh()) {
                preparedStatement.setInt(4, 1);
            }else {
                preparedStatement.setInt(4, 0);
            }
            preparedStatement.setInt(5,customer.getCmnd());
            preparedStatement.setInt(6,customer.getSoDienThoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDiaChi());
            preparedStatement.setInt(9, id);

            preparedStatement.executeUpdate();//update tra ve so luong record bi anh huong.

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();//update tra ve so luong record bi anh huong.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> FindByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);
            preparedStatement.setString(1, "%"+name+"%");

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idLoaiKhach = resultSet.getInt("id_loai_khach");
                String ten = resultSet.getString("ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                boolean gioiTinh = false;
                String gioi_tinh= resultSet.getString("gioi_tinh");
                if(gioi_tinh.equals("1")) {
                    gioiTinh = true;
                }
                int idCard = resultSet.getInt("cmnd");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");
                Customer customer = new Customer(id,idLoaiKhach, ten, ngaySinh, gioiTinh, idCard, soDienThoai, email, diaChi);

                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer FindById(int id) {
        Customer customer= null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idLoaiKhach = resultSet.getInt("id_loai_khach");
                String ten = resultSet.getString("ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                boolean gioiTinh = false;
                String gioi_tinh= resultSet.getString("gioi_tinh");
                if(gioi_tinh.equals("1")) {
                    gioiTinh = true;
                }
                int idCard = resultSet.getInt("cmnd");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");

                customer = new Customer(id,idLoaiKhach, ten, ngaySinh, gioiTinh, idCard, soDienThoai, email, diaChi);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
