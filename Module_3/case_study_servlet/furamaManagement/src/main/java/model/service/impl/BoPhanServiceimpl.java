package model.service.impl;

import model.bean.BoPhan;
import model.repository.BoPhanRepository;
import model.repository.impl.BoPhanRepositoryImpl;
import model.service.BoPhanService;

import java.util.List;

public class BoPhanServiceimpl implements BoPhanService {
        BoPhanRepository boPhanRepository = new BoPhanRepositoryImpl();
    @Override
    public List<BoPhan> findAll() {
        return boPhanRepository.findAll();
    }
}
