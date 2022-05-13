package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void save(User user);

    void delete(User blog);

    Page<User> getAllUser(String phoneNumber, String email, Pageable pageable );
}
