package caseStudy.controller;

import caseStudy.model.Employee;
import caseStudy.service.EmployeeService;
import caseStudy.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService= new EmployeeServiceImpl();

    public void save(Employee employee){
        employeeService.save(employee);
    }

    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    public List<Employee> search(String name){
        return employeeService.search(name);
    }

    public List<Employee> sort(){
        return employeeService.sort();
    }
}
