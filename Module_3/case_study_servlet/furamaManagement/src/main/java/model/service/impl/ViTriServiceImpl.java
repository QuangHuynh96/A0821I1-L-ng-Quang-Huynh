package model.service.impl;

import model.bean.ViTri;
import model.repository.ViTriRepository;
import model.repository.impl.ViTriRepositoryImpl;
import model.service.ViTriService;

import java.util.List;

public class ViTriServiceImpl implements ViTriService {
    ViTriRepository viTriRepository = new ViTriRepositoryImpl();
    @Override
    public List<ViTri> findAll() {
        return viTriRepository.findAll();
    }
}
