package model.repository;

import model.bean.KieuThue;
import model.bean.LoaiKhach;

import java.util.List;

public interface RentalTypeDAO {
    List<KieuThue> findAll();
}
