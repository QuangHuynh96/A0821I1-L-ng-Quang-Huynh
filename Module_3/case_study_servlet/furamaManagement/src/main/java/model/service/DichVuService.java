package model.service;

import model.bean.Customer;
import model.bean.DichVu;

import java.util.List;

public interface DichVuService {
    List<DichVu> findAll();
    void save(DichVu dichVu);
    void update(int id, DichVu dichVu);
    void remove(int id);
    List<DichVu> FindByName(String name);
    DichVu FindById(int id);
}
