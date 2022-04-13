package model.repository;

import model.bean.TrinhDo;

import java.util.List;

public interface TrinhDoRepository {
    List<TrinhDo> findAll();
}
