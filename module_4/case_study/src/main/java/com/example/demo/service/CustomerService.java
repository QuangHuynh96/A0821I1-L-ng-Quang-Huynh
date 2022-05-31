package com.example.demo.service;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    void save(DtoCustomer dtoCustomer);

    void delete(Customer customer);

    Page<Customer> getAllCustomer(String key_name, String key_phoneNumber, String key_idCard, Pageable pageable );

}
