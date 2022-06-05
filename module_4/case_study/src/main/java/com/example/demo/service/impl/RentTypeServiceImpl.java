package com.example.demo.service.impl;

import com.example.demo.entity.RentType;
import com.example.demo.repository.RentTypeRepository;
import com.example.demo.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getList() {
        return rentTypeRepository.findAll();
    }
}
