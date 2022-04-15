package model.repository.impl;

import model.bean.BenhNhan;
import model.repository.BaseRepository;
import model.repository.BenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoryImpl implements BenhNhanRepository {
    private static final String FINDALL = "select * from benhNhan where delete_flag = true;";
    private static final String FINDBYID = "select * from benhNhan where delete_flag = true and idBenhNhan = ?;";
//    private static final String ADDNEW = "insert into Auther (`name`, nick_name, address)\n" +
//            "values (?, ?, ?);";
    private static final String DELETE = "update benhNhan set delete_flag = false where idBenhNHan = ?;";
//    private static final String UPDATE = "update benhNhan set `name` = ?, nick_name = ?, address = ?  where id_author = ? and delete_flag = true;";
    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhNhan = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                BenhNhan benhNhan = new BenhNhan(idBenhNhan, ten);
                benhNhanList.add(benhNhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhanList;
    }

    @Override
    public boolean add(BenhNhan benhNhan) {
        return false;
    }

    @Override
    public boolean update(BenhNhan benhNhan) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public BenhNhan findById(int id) {
        return null;
    }
}
