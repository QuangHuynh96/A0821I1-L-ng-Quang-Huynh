package model.repository.impl;

import model.bean.KieuThue;
import model.bean.LoaiDichVu;
import model.repository.BaseRepository;
import model.repository.ServiceTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAOImpl implements ServiceTypeDAO {
    private static final String FINDALL = "select * from loai_dich_vu;";
    @Override
    public List<LoaiDichVu> findAll() {
        List<LoaiDichVu> loaiDichVuList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten");
                LoaiDichVu loaiDichVu = new LoaiDichVu(id, name);
                loaiDichVuList.add(loaiDichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loaiDichVuList;
    }
}
