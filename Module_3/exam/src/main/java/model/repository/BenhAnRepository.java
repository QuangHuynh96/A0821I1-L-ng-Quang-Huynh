package model.repository;

import model.bean.BenhAn;
import model.bean.BenhNhan;

import java.util.List;

public interface BenhAnRepository {
    List<BenhAn> findAll();
    boolean add(BenhAn benhAn);
    boolean update(BenhAn benhAn);
    boolean delete(int id);
    //    List<BenhAn> search(String name, String nickName, String address);
    BenhAn findById(int id);
}
