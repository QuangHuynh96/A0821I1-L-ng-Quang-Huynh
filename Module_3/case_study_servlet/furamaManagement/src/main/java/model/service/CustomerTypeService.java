package model.service;

import model.bean.Customer;
import model.bean.LoaiKhach;

import java.util.List;

public interface CustomerTypeService {
    List<LoaiKhach> findAll();
    void save(LoaiKhach loaiKhach);
    void update(int id, LoaiKhach loaiKhach);
    void remove(int id);
    Customer FindByName(String name);
}
