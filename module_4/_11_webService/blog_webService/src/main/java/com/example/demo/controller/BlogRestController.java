package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories/list")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();

        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }


    @GetMapping("/blogs/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getBlogs() {

        return  blogService.getList();
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findBlogById( @PathVariable("id") Blog blog){
        if(blog == null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<Blog>> findCategoryById( @PathVariable("id") Long id){
        List<Blog> blogs = blogService.findByCategory(id);

        if(blogs == null){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }

}
