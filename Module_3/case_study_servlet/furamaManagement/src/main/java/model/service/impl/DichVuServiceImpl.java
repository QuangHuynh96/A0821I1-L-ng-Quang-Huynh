package model.service.impl;

import model.bean.DichVu;
import model.repository.DichVuRepository;
import model.repository.impl.DichVuRepositoryImpl;
import model.service.DichVuService;

import java.util.List;

public class DichVuServiceImpl implements DichVuService {
    DichVuRepository dichVuRepository =  new DichVuRepositoryImpl();
    @Override
    public List<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public void save(DichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    @Override
    public void update(int id, DichVu dichVu) {
        dichVuRepository.update(id, dichVu);
    }

    @Override
    public void remove(int id) {
        dichVuRepository.remove(id);
    }

    @Override
    public List<DichVu> FindByName(String name) {
        return dichVuRepository.FindByName(name);
    }

    @Override
    public DichVu FindById(int id) {
        return dichVuRepository.FindById(id);
    }
}
