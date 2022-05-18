package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book where name like concat('%',:name,'%')  and category like concat('%',:category,'%')",
            nativeQuery = true)
    Page<Book> getAllBook(@Param("name") String name, @Param("category") String category, Pageable pageable);
}
