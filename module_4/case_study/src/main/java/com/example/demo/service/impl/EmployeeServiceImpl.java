package com.example.demo.service.impl;

import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.*;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ContractRepository contractRepository;

    @Override
    public void save(DtoEmployee dtoEmployee) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee, employee);

        //tạo user
        User user = new User();
        user.setName(employee.getEmail());
        user.setPassword(encoder.encode("123"));
        userRepository.save(user);

        //cấp quyền user
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roleRepository.findRoleByName("ROLE_EMP"));
        userRoleRepository.save(userRole);

        //save employee
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
        return employeeRepository.getListEmployee();
    }

    @Override
    public Page<Employee> getAllEmployee(String key_name, String key_phoneNumber, String key_idCard, String key_email, Pageable pageable) {
        return employeeRepository.findAll(key_name, key_phoneNumber, key_idCard, key_email, pageable);
    }
}
