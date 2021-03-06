package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee where name like concat('%',:name,'%')  and phone like concat('%',:phone,'%') and id_card like concat('%',:idCard,'%') and email like concat('%',:email,'%') and flag = true",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM employee where name like concat('%',:name,'%')  and phone like concat('%',:phone,'%') and id_card like concat('%',:idCard,'%') and email like concat('%',:email,'%') and flag = true ) abc ")
    Page<Employee> findAll(@Param("name") String name, @Param("phone") String phone, @Param("idCard") String idCard, @Param("email") String email, Pageable pageable);

    @Query(value = "select * from employee where flag = true ", nativeQuery = true)
    List<Employee> getListEmployee();
}
