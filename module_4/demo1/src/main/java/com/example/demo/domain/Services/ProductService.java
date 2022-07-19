package com.example.demo.domain.Services;
import com.example.demo.infrastructure.dto.ProductDto;
import com.example.demo.infrastructure.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void save(ProductDto productDto);

    void delete(Product product);

    Optional<Product> findCustomerById(long id);

    List<Product> getList();
}
