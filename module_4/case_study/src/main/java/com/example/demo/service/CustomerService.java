package com.example.demo.service;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    void save(DtoCustomer dtoCustomer);

    void delete(Customer customer);

    List<Customer> getList();

    boolean checkIdCard(String idCard);

    boolean checkId(Long id);

    Page<Customer> getAllCustomer(String key_name, String key_phoneNumber, String key_idCard, Pageable pageable );

}
