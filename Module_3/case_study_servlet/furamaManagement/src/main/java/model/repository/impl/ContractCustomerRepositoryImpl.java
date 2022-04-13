package model.repository.impl;

import model.bean.ContractCustomerOder;
import model.repository.BaseRepository;
import model.repository.ContractCustomerOderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractCustomerRepositoryImpl implements ContractCustomerOderRepository {
    private static final String FINDALL = " select hop_dong.id_dich_vu, khach_hang.ten, khach_hang.so_dien_thoai , dich_vu_di_kem.ten, hop_dong.ngay_lam_hop_dong \n" +
            " from khach_hang\n" +
            " join hop_dong on khach_hang.id = hop_dong.id_khach_hang\n" +
            " left join hop_dong_chi_tiet on hop_dong.id = hop_dong_chi_tiet.id_hop_dong\n" +
            " left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id\n" +
            " where hop_dong.delete_flag = true\n" +
            " order by hop_dong.id desc;";
    @Override
    public List<ContractCustomerOder> findAll() {
        List<ContractCustomerOder> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDichVu = resultSet.getInt(1);
                String ten = resultSet.getString(2);
                int soDienThoai = resultSet.getInt(3);
                String tenDichVuDiKem = resultSet.getString(4);
                String ngayLamHopDong = resultSet.getString(5);
                ContractCustomerOder contractCustomerOder = new ContractCustomerOder(idDichVu, ten, soDienThoai, tenDichVuDiKem, ngayLamHopDong);
                list.add(contractCustomerOder);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
