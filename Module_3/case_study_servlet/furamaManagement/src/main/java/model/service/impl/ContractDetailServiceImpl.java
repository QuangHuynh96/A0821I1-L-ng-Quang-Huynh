package model.service.impl;

import model.bean.HopDongChiTiet;
import model.repository.ContractDetailRepository;
import model.repository.impl.ContractDetailRepositoryImpl;
import model.service.ContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();
    @Override
    public List<HopDongChiTiet> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public boolean save(HopDongChiTiet hopDongChiTiet) {
        return contractDetailRepository.save(hopDongChiTiet);
    }

    @Override
    public boolean update(int id, HopDongChiTiet hopDongChiTiet) {
        return contractDetailRepository.update(id, hopDongChiTiet);
    }

    @Override
    public void remove(int id) {
        contractDetailRepository.remove(id);
    }

    @Override
    public List<HopDongChiTiet> FindByName(String name) {
        return contractDetailRepository.FindByName(name);
    }

    @Override
    public HopDongChiTiet FindById(int id) {
        return contractDetailRepository.FindById(id);
    }
}
