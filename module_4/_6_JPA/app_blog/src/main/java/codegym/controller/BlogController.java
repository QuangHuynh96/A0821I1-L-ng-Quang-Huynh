package codegym.controller;

import codegym.entity.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping()
    public String displayCreate(@RequestParam(name = "nameBlog", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("blogs", blogService.findByName(name));
        } else {
            model.addAttribute("blogs", blogService.getList());
        }
        return "book/list";
    }

    @GetMapping("create")
    public String displayCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("book") Blog blog, Model model) {
        blogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String viewUpdate(@RequestParam("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("Blog", blog);
        model.addAttribute("link", "/update");
        return "/blog/create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("Blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("Blog", blog);
        return "/blog/view";
    }
}
