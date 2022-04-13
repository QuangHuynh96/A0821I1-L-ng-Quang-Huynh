package model.repository;

import model.bean.HopDong;

import java.util.List;

public interface ContractRepository {
    List<HopDong> findAll();
    boolean save(HopDong hopDong);
    boolean update(int id, HopDong hopDong);
    void remove(int id);
    List<HopDong> FindByName(String name);
    HopDong FindById(int id);
}
