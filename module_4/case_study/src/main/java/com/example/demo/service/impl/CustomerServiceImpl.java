package com.example.demo.service.impl;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
        CustomerRepository customerRepository;

    @Override
    public void save(DtoCustomer dtoCustomer) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dtoCustomer, customer);
        customer.setFlag(true);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customer.setFlag(false);
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.findAll();
    }

    @Override
    public boolean checkIdCard(String idCard) {
        return customerRepository.existsByIdCard(idCard);
    }

    @Override
    public boolean checkId(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Page<Customer> getAllCustomer(String key_name, String key_phoneNumber, String key_idCard, Pageable pageable) {
        return customerRepository.findAll(key_name, key_phoneNumber, key_idCard, pageable);
    }
}
