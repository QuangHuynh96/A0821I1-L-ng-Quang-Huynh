package com.example.demo.service.impl;

import com.example.demo.entity.ServiceType;
import com.example.demo.repository.ServiceTypeRepository;
import com.example.demo.service.ServiceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeDAOImpl implements ServiceTypeDAO {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> getList() {
        return serviceTypeRepository.findAll();
    }
}
