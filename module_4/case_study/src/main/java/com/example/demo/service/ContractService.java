package com.example.demo.service;

import com.example.demo.dto.DtoContract;
import com.example.demo.entity.Contract;

import java.util.List;

public interface ContractService {

    void save(DtoContract dtoContract);

    void delete(Contract contract);

    List<Contract> getList();
}
