package model.service;

import model.bean.HopDong;

import java.util.List;

public interface ContractService {
    List<HopDong> findAll();
    boolean save(HopDong hopDong);
    boolean update(int id, HopDong hopDong);
    void remove(int id);
    List<HopDong> FindByName(String name);
    HopDong FindById(int id);
}
