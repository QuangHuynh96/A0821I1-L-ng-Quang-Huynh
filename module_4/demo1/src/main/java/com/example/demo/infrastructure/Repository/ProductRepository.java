package com.example.demo.infrastructure.Repository;

import com.example.demo.infrastructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where flag = true ", nativeQuery = true)
    List<Product> getProductList();
}
