package com.example.demo.infrastructure.Repository;

import com.example.demo.infrastructure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer where flag = true ", nativeQuery = true)
    List<Customer> getCustomerList();
}
