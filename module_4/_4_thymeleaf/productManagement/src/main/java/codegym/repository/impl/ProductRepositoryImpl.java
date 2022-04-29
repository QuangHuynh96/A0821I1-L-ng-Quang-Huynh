package codegym.repository.impl;

import codegym.entity.Product;
import codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("1", new Product("1", "phone1", 1000, "Dien thoai di dong 1", "nokia1"));
        productMap.put("2", new Product("2", "phone2", 1000, "Dien thoai di dong 2", "nokia2"));
        productMap.put("3", new Product("2", "phone3", 1000, "Dien thoai di dong 3", "nokia3"));
        productMap.put("4", new Product("2", "phone4", 1000, "Dien thoai di dong 4", "nokia4"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void update(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void delete(String id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
        }
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }
}
