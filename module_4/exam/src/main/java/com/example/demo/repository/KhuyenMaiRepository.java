package com.example.demo.repository;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> {

    @Query(value = "SELECT * FROM khuyen_mai where (money =:money  or start_day like concat('%',:startDay,'%') and end_day like concat('%',:endDay,'%')) and flag = true ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM khuyen_mai where (money =:money  or start_day like concat('%',:startDay,'%') and end_day like concat('%',:endDay,'%')) and flag = true ) abc ")
    Page<KhuyenMai> findAll(@Param("money") int money, @Param("startDay") String startDay, @Param("endDay") String endDay, Pageable pageable);

    @Query(value = "SELECT * FROM khuyen_mai where (money = :money  and start_day like concat('%',:startDay,'%') and end_day like concat('%',:endDay,'%')) and flag = true",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM khuyen_mai where (money = :money  and start_day like concat('%',:startDay,'%') and end_day like concat('%',:endDay,'%')) and flag = true) abc ")
    Page<KhuyenMai> search(@Param("money") int money, @Param("startDay") String startDay, @Param("endDay") String endDay, Pageable pageable);

}
