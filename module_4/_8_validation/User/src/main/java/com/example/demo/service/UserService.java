package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    void save(User user);

    void delete(User blog);

    Optional<User> findById(Long id);

    Page<User> getAllUser(String phoneNumber, String email, Pageable pageable );
}
