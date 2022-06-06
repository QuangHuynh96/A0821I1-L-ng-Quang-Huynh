package com.example.demo.service.impl;

import com.example.demo.dto.DtoService;
import com.example.demo.entity.Service;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceDAOImpl implements ServiceDAO {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public void save(DtoService dtoService) {
        Service service = new Service();
        BeanUtils.copyProperties(dtoService, service);
        service.setFlag(true);
        serviceRepository.save(service);
    }

    @Override
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }
}
