package com.example.demo.service;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    void save(DtoEmployee dtoEmployee);

    void delete(Employee employee);

    List<Employee> getList();

    Page<Employee> getAllEmployee(String key_name, String key_phoneNumber, String key_idCard, String key_email, Pageable pageable );
}
