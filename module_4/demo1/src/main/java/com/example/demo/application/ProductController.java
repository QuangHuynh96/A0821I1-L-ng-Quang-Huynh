package com.example.demo.application;

import com.example.demo.domain.Services.ProductService;
import com.example.demo.infrastructure.dto.ProductDto;
import com.example.demo.infrastructure.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/create")
    public String showCreate(Model model) {
        ProductDto productDto =  new ProductDto();

        model.addAttribute("productDto", productDto);
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("productDto") ProductDto productDto,
                         BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors() ) {
            return "/product/create";
        }else {
            productService.save(productDto);
            return "redirect:/product/list";
        }
    }

    // -------------------------------------------------------------------------------------- list --
    @GetMapping("/list")
    public String getList(Model model) {
        try {
            List<Product> products = productService.getList();
            model.addAttribute("products", products);
            return "/product/list";
        }
        catch (Exception e) {
            return "redirect:/";
        }
    }

    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Product product) {
        productService.delete(product);
        return "redirect:/product/list";
    }

    // -------------------------------------------------------------------------------------- update --
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")  Product product, Model model) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        return "/product/create";
    }

}
