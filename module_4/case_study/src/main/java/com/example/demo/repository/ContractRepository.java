package com.example.demo.repository;

import com.example.demo.entity.Contract;
import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "SELECT * FROM contract where flag = true ", nativeQuery = true)
    List<Contract> getList();

}
