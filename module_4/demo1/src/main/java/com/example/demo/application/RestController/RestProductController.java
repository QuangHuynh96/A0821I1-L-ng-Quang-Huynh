package com.example.demo.application.RestController;

import com.example.demo.infrastructure.entity.Product;
import com.example.demo.domain.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        List<Product> productList = productService.getList();
        Product product = new Product();
        product.setName("iphone");
        productList.add(product);
        return productList;
    }
}
