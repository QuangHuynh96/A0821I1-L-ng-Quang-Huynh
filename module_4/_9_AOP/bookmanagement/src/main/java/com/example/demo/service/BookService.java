package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    void save(Book book);

    void delete(Book book);

    void edit(Book book);

    List<Book> getAll();

    Page<Book> getAllBook(String name, String category, Pageable pageable );
}
