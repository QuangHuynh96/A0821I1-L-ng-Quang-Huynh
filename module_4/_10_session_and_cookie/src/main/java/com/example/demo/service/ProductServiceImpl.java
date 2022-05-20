package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productRepository.save(product);
    }

    @Override
    public void delete(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productRepository.delete(product);
    }

    @Override
    public Page<Product> getAllProduct(String name, Pageable pageable) {
        return productRepository.getAllProduct(name, pageable);
    }
}
