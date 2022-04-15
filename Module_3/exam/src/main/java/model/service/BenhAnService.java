package model.service;

import model.bean.BenhAn;
import model.bean.BenhNhan;

import java.util.List;

public interface BenhAnService {
    List<BenhAn> findAll();
    List<String> add(BenhAn benhAn);
    List<String> update(BenhAn benhAn);
    boolean delete(int id);
    //    List<Auther> search(String name, String nickName, String address);
    BenhAn findById(int id);
}
