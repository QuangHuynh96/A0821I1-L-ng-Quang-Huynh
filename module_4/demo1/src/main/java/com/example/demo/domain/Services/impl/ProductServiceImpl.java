package com.example.demo.domain.Services.impl;

import com.example.demo.domain.Services.ProductService;
import com.example.demo.infrastructure.Repository.ProductRepository;
import com.example.demo.infrastructure.entity.Product;
import com.example.demo.infrastructure.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        product.setFlag(true);
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        product.setFlag(false);
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findCustomerById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getList() {
        return productRepository.getProductList();
    }
}
