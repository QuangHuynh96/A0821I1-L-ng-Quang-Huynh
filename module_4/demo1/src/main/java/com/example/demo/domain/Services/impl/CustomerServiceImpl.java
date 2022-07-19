package com.example.demo.domain.Services.impl;

import com.example.demo.domain.Services.CustomerService;
import com.example.demo.infrastructure.Repository.CustomerRepository;
import com.example.demo.infrastructure.dto.CustomerDto;
import com.example.demo.infrastructure.entity.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        customer.setFlag(true);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customer.setFlag(false);
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getList() {
         return customerRepository.getCustomerList();
    }
}
