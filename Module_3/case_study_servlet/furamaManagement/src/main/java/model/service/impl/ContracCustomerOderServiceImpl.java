package model.service.impl;

import model.bean.ContractCustomerOder;
import model.repository.ContractCustomerOderRepository;
import model.repository.impl.ContractCustomerRepositoryImpl;
import model.service.ContractCustomerOderService;

import java.util.List;

public class ContracCustomerOderServiceImpl implements ContractCustomerOderService {
    ContractCustomerOderRepository contractCustomerOderRepository = new ContractCustomerRepositoryImpl();
    @Override
    public List<ContractCustomerOder> findAll() {
        return contractCustomerOderRepository.findAll();
    }
}
