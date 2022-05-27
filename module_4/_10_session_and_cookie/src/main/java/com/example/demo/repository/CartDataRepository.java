package com.example.demo.repository;

import com.example.demo.entity.CartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDataRepository extends JpaRepository<CartData, Long> {
}
