package model.service.impl;

import model.bean.HopDong;
import model.repository.ContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contracRepository = new ContractRepositoryImpl();
    @Override
    public List<HopDong> findAll() {
        return contracRepository.findAll();
    }

    @Override
    public boolean save(HopDong hopDong) {
        return contracRepository.save(hopDong);
    }

    @Override
    public boolean update(int id, HopDong hopDong) {
        return contracRepository.update(id,hopDong);
    }

    @Override
    public void remove(int id) {
        contracRepository.remove(id);
    }

    @Override
    public List<HopDong> FindByName(String name) {
        return contracRepository.FindByName(name);
    }

    @Override
    public HopDong FindById(int id) {
        return contracRepository.FindById(id);
    }
}
