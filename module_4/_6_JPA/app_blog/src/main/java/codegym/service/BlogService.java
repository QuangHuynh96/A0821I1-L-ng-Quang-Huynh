package codegym.service;

import codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    List<Blog> getList();
    Blog findById(int id);
    List<Blog> findByName(String name);
    Page<Blog> findAll(Pageable pageable);
}
