package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.updateBlog(blog.getTitle(), blog.getAuthor(), blog.getContent(), blog.getId());
    }

    @Override
    public Page<Blog> getAllBlog(String author, String category, Pageable pageable) {
        return blogRepository.findAll(author, category, pageable);
    }
}
