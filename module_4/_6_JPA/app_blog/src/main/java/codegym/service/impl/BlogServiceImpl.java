package codegym.service.impl;

import codegym.entity.Blog;
import codegym.repository.BlogRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if( blog != null) {
            blogRepository.delete(blog);
        }
    }

    @Override
    public List<Blog> getList() {
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(b-> {
            blogs.add(b);
        });
        return blogs;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findAllByNameContaining(name);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll(pageable);
        return null;
    }
}
