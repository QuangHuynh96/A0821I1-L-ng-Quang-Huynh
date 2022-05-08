package codegym.controller;

import codegym.entity.Product;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;


        @GetMapping()
        public String list(Model model) {
            List<Product> products = productService.findAll();
            model.addAttribute("products", products);
            return "/product/list";
        }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<String> producers = new ArrayList<>();
        producers.add("nokia");
        producers.add("samsung");
        producers.add("apple");
        model.addAttribute("producers", producers);
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping ("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.findAll();
        List<Product> searchProducts = new ArrayList<>();
        products.forEach(p->{
            if(p.getName().equals(name)) {
                searchProducts.add(p);
            }
        });
        model.addAttribute("products", searchProducts);
        return "/product/list";
    }

    @GetMapping("/update")
    public String viewUpdate(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        //fakelist
        List<String> producers = new ArrayList<>();
        producers.add("nokia");
        producers.add("samsung");
        producers.add("apple");
        model.addAttribute("producers", producers);

        model.addAttribute("product", product);
        return "/product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewProduct(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/view";
    }

}
