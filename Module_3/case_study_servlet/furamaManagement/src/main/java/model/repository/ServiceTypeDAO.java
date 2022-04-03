package model.repository;

import model.bean.LoaiDichVu;

import java.util.List;

public interface ServiceTypeDAO {
    List<LoaiDichVu> findAll();

}
