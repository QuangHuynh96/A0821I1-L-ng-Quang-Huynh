package com.example.demo.service;

import com.example.demo.dto.DtoContract;
import com.example.demo.dto.DtoContractDetail;
import com.example.demo.entity.Contract;
import com.example.demo.entity.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    void save(DtoContractDetail dtoContractDetail);

    void delete(ContractDetail contractDetail);

    List<ContractDetail> getList(Long id);
}
