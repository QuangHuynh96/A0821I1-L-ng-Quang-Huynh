package com.example.demo.infrastructure.Repository;

import com.example.demo.infrastructure.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OderRepository extends JpaRepository<Oder, Long> {

    @Query(value = "select * from oder where flag = true ", nativeQuery = true)
    List<Oder> getOderList();
}
