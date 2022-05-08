package codegym.repository;

import codegym.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository {
    List<Product> findAll();
    void create (Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
}
