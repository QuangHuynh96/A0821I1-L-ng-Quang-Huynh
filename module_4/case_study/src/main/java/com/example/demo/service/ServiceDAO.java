package com.example.demo.service;

import com.example.demo.dto.DtoService;
import com.example.demo.entity.Service;

import java.util.List;

public interface ServiceDAO {
    void save(DtoService dtoservice);
    List<Service> getAllService();
}
