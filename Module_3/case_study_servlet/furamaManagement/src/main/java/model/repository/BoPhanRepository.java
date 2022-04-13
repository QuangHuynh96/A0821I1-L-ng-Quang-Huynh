package model.repository;

import model.bean.BoPhan;

import java.util.List;

public interface BoPhanRepository {
    List<BoPhan> findAll();
}
