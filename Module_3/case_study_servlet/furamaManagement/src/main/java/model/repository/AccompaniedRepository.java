package model.repository;

import model.bean.DichVuDiKem;

import java.util.List;

public interface AccompaniedRepository {
    List<DichVuDiKem> findAll();
}
