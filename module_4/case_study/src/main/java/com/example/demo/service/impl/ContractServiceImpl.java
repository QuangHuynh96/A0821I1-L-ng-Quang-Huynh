package com.example.demo.service.impl;

import com.example.demo.dto.DtoContract;
import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public void save(DtoContract dtoContract) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(dtoContract, contract);
        contract.setFlag(true);
        contractRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        contract.setFlag(false);
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> getList() {
        return contractRepository.findAll();
    }
}
