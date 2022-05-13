package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM user where phone_number like concat('%',:phoneNumber,'%')  and email like concat('%',:email,'%') ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM user where phone_number like concat('%',:phoneNumber,'%')  and email like concat('%',:email,'%') ) abc ")
    Page<User> findAll(@Param("phoneNumber") String phoneNumber, @Param("email") String email, Pageable pageable);
}
