package com.example.demo.service;

import com.example.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    void save(Category category);

    void delete(Category category);

    void edit(Category category);

    List<Category> getAllCategory();

}
