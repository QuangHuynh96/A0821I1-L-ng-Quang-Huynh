package codegym.service;

import codegym.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create (Product product);
    void update(Product product);
    void delete(String id);
    Product findById(String id);
}
