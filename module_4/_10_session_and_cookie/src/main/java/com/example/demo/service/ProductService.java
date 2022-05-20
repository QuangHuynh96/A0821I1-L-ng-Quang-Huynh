package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    void save(ProductDto productDto);

    void delete(ProductDto productDto);

    Page<Product> getAllProduct(String name, Pageable pageable);
}
