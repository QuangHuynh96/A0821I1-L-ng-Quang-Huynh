package model.service.impl;

import model.bean.DichVuDiKem;
import model.repository.AccompaniedRepository;
import model.repository.impl.AccompaniedRepositoryImpl;
import model.service.AccompaniedService;

import java.util.List;

public class AccompaniedServiceImpl implements AccompaniedService {
    AccompaniedRepository accompaniedRepository = new AccompaniedRepositoryImpl();
    @Override
    public List<DichVuDiKem> findAll() {
        return accompaniedRepository.findAll();
    }
}
