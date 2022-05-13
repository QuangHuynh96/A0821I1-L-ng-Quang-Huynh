package com.example.demo.service;

import com.example.demo.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface BlogService {

    void save(Blog blog);

    void delete(Blog blog);

    void edit(Blog blog);

    Page<Blog> getAllBlog(String author, String category, Pageable pageable );
}
