package com.example.demo.domain.Services;

import com.example.demo.infrastructure.dto.CustomerDto;
import com.example.demo.infrastructure.entity.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    void save(CustomerDto customer);

    void delete(Customer customer);

    Optional<Customer> findCustomerById(long id);

    List<Customer> getList();

}
