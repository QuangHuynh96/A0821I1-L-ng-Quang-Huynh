package model.service;

import model.bean.BenhNhan;

import java.util.List;

public interface BenhNhanService {
    List<BenhNhan> findAll();
    List<String> add(BenhNhan benhNhan);
    List<String> update(BenhNhan benhNhan);
    boolean delete(int id);
//    List<Auther> search(String name, String nickName, String address);
    BenhNhan findById(int id);
}
