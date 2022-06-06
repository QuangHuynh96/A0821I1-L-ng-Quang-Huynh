package com.example.demo.service.impl;

import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Contract;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ContractService;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContractRepository contractRepository;

    @Override
    public void save(DtoEmployee dtoEmployee) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee, employee);
        User user = new User();
        user.setName(employee.getEmail());
        user.setPassword("123");
        userRepository.save(user);
        employee.setUser(user);
        employee.setFlag(true);
        employeeRepository.save(employee);

    }

    @Override
    public void delete(Employee employee) {
        employee.setFlag(false);
        employeeRepository.save(employee);
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
