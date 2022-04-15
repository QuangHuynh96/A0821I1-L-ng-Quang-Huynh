package model.repository.impl;

import model.bean.BenhAn;
import model.repository.BaseRepository;
import model.repository.BenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements BenhAnRepository {
    private static final String FINDALL = " select * from benhAn where delete_flag = true;";
    private static final String FINDBYID = " select * from benhAn where delete_flag = true and idBenhAn = ?;";
    private static final String DELETE = "update benhAn set delete_flag = false where idBenhAn = ?;";
    private static final String UPDATE = "update benhAn set ngayNhapVien = ?, ngayRaVien = ?, lyDoNhapVien = ? where idBenhAn = ?;";
    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhAn = resultSet.getInt(1);
                int idBenhNhan = resultSet.getInt(2);
                String ngayNhapVien = resultSet.getString(3);
                String ngayRaVien = resultSet.getString(4);
                String lyDoNhapVien = resultSet.getString(5);
                BenhAn benhAn = new BenhAn(idBenhAn, idBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
                benhAnList.add(benhAn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAnList;
    }

    @Override
    public boolean add(BenhAn benhAn) {
        return false;
    }

    @Override
    public boolean update(BenhAn benhAn) {
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, benhAn.getNgayNhapVien());
            preparedStatement.setString(2, benhAn.getNgayRaVien());
            preparedStatement.setString(3, benhAn.getLyDoNhapVien());
            preparedStatement.setInt(4, benhAn.getIdBenhAn());
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
    public BenhAn findById(int id) {
       BenhAn benhAn = null;
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhAn = resultSet.getInt(1);
                int idBenhNhan = resultSet.getInt(2);
                String ngayNhapVien = resultSet.getString(3);
                String ngayRaVien = resultSet.getString(4);
                String lyDoNhapVien = resultSet.getString(5);
                benhAn = new BenhAn(idBenhAn, idBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAn;
    }
}
