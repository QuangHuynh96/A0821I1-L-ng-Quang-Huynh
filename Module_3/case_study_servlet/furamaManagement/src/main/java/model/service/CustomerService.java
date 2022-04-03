package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void update(int id, Customer customer);
    void remove(int id);
    List<Customer> FindByName(String name);
    Customer FindById(int id);
}
