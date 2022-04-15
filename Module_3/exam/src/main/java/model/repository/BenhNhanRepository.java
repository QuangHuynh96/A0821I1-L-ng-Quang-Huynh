package model.repository;

import model.bean.BenhNhan;

import java.util.List;

public interface BenhNhanRepository {
    List<BenhNhan> findAll();
    boolean add(BenhNhan benhNhan);
    boolean update(BenhNhan benhNhan);
    boolean delete(int id);
//    List<BenhNhan> search(String name, String nickName, String address);
    BenhNhan findById(int id);
}
