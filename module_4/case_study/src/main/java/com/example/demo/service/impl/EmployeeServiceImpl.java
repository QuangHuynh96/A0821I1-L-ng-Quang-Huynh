package com.example.demo.service.impl;

import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(DtoEmployee dtoEmployee) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee, employee);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAllEmployee(String key_name, String key_phoneNumber, String key_idCard, String key_email, Pageable pageable) {
        return employeeRepository.findAll(key_name, key_phoneNumber, key_idCard, key_email, pageable);
    }
}
