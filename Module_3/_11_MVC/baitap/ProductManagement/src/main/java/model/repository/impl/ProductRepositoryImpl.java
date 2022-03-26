package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "phone",1500, "dien thoai di dong", "apple"));
        products.put(2, new Product(2, "tablet",2000, "may tinh bang", "samsung"));
        products.put(3, new Product(3, "laptop",5000, "may tinh xach tay", "dell"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product FindByName(String name) {
        for(Product p : products.values()) {
            if( p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
