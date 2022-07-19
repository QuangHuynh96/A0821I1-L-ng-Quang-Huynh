package com.example.wed_service.repository;

import com.example.wed_service.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value ="SELECT * FROM student where flag = true", nativeQuery = true)
    List<Student> getStudent();
    @Query(value = "SELECT * FROM student where name like concat('%',:name,'%') and phone like concat('%',:phone,'%') and email like concat('%',:email,'%') and flag = true ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM student where name like concat('%',:name,'%') and phone like concat('%',:phone,'%') and email like concat('%',:email,'%') and flag = true ) abc ")
    Page<Student> findAll(@Param("name") String name, @Param("phone") String phone, @Param("email") String email, Pageable pageable);
}
