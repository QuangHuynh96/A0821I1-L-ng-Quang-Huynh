package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> setCategory(){
        List<Category> categories = categoryService.getAllCategory();
        return categories;
    }

    @GetMapping("/list")
    public String getAllBlog(
            @RequestParam(defaultValue = "") String key_author,
            @RequestParam(defaultValue = "") String key_category,
            @PageableDefault(size = 5) Pageable pageable,
            Model model) {
        Page<Blog> blogs = blogService.getAllBlog(key_author, key_category, pageable);
        model.addAttribute("blogs", blogs);
        return "/blog/list" ;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Blog blog) {
        blogService.delete(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog", blog);
        model.addAttribute("categories", setCategory());
        model.addAttribute("action", "/blog/create");
        return "/blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Blog blog, Model model) {
        model.addAttribute("blog", blog);
        model.addAttribute("categories", setCategory());
        model.addAttribute("action", "/blog/create");
        return "/blog/create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/blog/list";
    }

}
