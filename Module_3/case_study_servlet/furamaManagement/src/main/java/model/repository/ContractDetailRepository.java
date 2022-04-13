package model.repository;

import model.bean.HopDong;
import model.bean.HopDongChiTiet;

import java.util.List;

public interface ContractDetailRepository {
    List<HopDongChiTiet> findAll();
    boolean save(HopDongChiTiet hopDongChiTiet);
    boolean update(int id, HopDongChiTiet hopDongChiTiet);
    void remove(int id);
    List<HopDongChiTiet> FindByName(String name);
    HopDongChiTiet FindById(int id);
}
