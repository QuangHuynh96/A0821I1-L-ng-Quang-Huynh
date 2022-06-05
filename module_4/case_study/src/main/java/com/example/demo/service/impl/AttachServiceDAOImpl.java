package com.example.demo.service.impl;

import com.example.demo.entity.AttachService;
import com.example.demo.repository.AttachServiceRepository;
import com.example.demo.service.AttachServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceDAOImpl implements AttachServiceDAO {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> getList() {
        return attachServiceRepository.findAll();
    }
}
