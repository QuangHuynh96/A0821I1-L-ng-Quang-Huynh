package caseStudy.service;

import caseStudy.model.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {
    List<Employee> search(String name);
    List<Employee> sort();
}
