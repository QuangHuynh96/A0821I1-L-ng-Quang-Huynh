package com.example.demo.service.impl;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
        CustomerRepository customerRepository;

    @Autowired
        UserRoleRepository userRoleRepository;

    @Autowired
        UserRepository userRepository;

    @Autowired
        RoleRepository roleRepository;

    @Override
    public void save(DtoCustomer dtoCustomer) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Customer customer = new Customer();
        BeanUtils.copyProperties(dtoCustomer, customer);

        User user = new User();
        user.setName(customer.getEmail());
        user.setPassword(encoder.encode("123"));
        userRepository.save(user);

        //cấp quyền user
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roleRepository.findRoleByName("ROLE_USER"));
        userRoleRepository.save(userRole);

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
        return customerRepository.getListCustomer();
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
