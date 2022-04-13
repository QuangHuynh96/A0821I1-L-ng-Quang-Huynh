package model.service;

import model.bean.Customer;
import model.bean.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    boolean save(Employees employees);
    boolean update(int id, Employees employees);
    void remove(int id);
    List<Employees> FindByName(String name);
    Employees FindById(int id);
}
