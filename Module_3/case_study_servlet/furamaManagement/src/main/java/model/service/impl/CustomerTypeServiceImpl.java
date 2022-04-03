package model.service.impl;

import model.bean.Customer;
import model.bean.LoaiKhach;
import model.repository.CustomerTypeRepository;
import model.repository.impl.CustomerTypeRepositoryImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<LoaiKhach> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(LoaiKhach loaiKhach) {
        customerTypeRepository.save(loaiKhach);
    }

    @Override
    public void update(int id, LoaiKhach loaiKhach) {
        customerTypeRepository.update(id, loaiKhach);
    }

    @Override
    public void remove(int id) {
        customerTypeRepository.remove(id);
    }

    @Override
    public Customer FindByName(String name) {
        return customerTypeRepository.FindByName(name);
    }
}
