package model.service.impl;

import model.bean.Customer;
import model.bean.Employees;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean save(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public boolean update(int id, Employees employees) {
        return employeeRepository.update(id,employees);
    }

    @Override
    public void remove(int id) {
        employeeRepository.remove(id);
    }

    @Override
    public List<Employees> FindByName(String name) {
        return employeeRepository.FindByName(name);
    }

    @Override
    public Employees FindById(int id) {
        return employeeRepository.FindById(id);
    }
}
