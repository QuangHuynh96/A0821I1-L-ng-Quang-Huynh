package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer FindById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
