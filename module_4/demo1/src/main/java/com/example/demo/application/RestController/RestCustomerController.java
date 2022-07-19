package com.example.demo.application.RestController;

import com.example.demo.domain.Services.CustomerService;
import com.example.demo.infrastructure.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerService.getList();
        Customer customer = new Customer();
        customer.setName("Huynh");
        customers.add(customer);
        return customers;
    }
}
