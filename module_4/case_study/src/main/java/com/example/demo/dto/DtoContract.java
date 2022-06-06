package com.example.demo.dto;

import com.example.demo.entity.ContractDetail;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Service;

import javax.persistence.*;
import java.util.List;

public class DtoContract {

    private Long id;
    private String startDay;
    private String endDay;
    private double deposit;
    private double totalMoney;

    @ManyToOne( targetEntity = Employee.class)
    private Employee employee;


    @ManyToOne( targetEntity = Customer.class)
    private Customer customer;


    @ManyToOne( targetEntity = Service.class)
    private Service service;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetails;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DtoContract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
