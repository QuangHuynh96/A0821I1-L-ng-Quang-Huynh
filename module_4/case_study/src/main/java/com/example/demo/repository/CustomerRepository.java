package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer where name like concat('%',:name,'%')  and phone like concat('%',:phone,'%') and id_card like concat('%',:idCard,'%') and flag = true ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM customer where name like concat('%',:name,'%')  and phone like concat('%',:phone,'%') and id_card like concat('%',:idCard,'%') and flag = true ) abc ")
    Page<Customer> findAll(@Param("name") String name,@Param("phone") String phone, @Param("idCard") String idCard, Pageable pageable);


}
