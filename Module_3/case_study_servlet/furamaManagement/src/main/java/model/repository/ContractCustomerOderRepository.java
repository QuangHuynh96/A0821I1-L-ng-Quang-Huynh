package model.repository;

import model.bean.ContractCustomerOder;

import java.util.List;

public interface ContractCustomerOderRepository {
    List<ContractCustomerOder> findAll();
}
