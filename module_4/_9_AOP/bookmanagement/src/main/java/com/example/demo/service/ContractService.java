package com.example.demo.service;

import com.example.demo.entity.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Contract> getallContract();

    Optional<Contract> findById(Long id);

    void save(Contract  contract);

    void delete(Contract contract);
}
