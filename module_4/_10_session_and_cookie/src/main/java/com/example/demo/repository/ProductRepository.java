package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT * FROM product where name like concat('%',:name,'%')",
            nativeQuery = true,
            countQuery = "select count(1) from product where name like concat('%',:name,'%')")
    Page<Product> getAllProduct(String name, Pageable pageable);
}
