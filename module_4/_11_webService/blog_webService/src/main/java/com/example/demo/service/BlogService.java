package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface BlogService {

    void save(Blog blog);

    void delete(Blog blog);

    void edit(Blog blog);

    Page<Blog> getAllBlog(String author, String category, Pageable pageable );

    List<Blog> getList();

    Optional<Blog> findById(Long id);

    List<Blog> findByCategory(Long id);
}
