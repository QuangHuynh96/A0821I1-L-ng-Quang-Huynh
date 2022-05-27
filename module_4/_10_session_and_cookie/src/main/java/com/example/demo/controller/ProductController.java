package com.example.demo.controller;

import com.example.demo.entity.CartData;
import com.example.demo.repository.CartDataRepository;
import com.example.demo.session.Cart;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CartDataRepository cartDataRepository;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

//    @GetMapping("/list")
//    public String getList(
//            @RequestParam(defaultValue = "") String key_name,
//            @PageableDefault(size = 6) Pageable pageable,
//            Model model) {
//        Page<Product> products = productService.getAllProduct(key_name, pageable);
//        model.addAttribute("products", products);
//        return "/product/listGroup";
//    }

    @GetMapping("/shop")
    public ModelAndView showShop(
            @RequestParam(defaultValue = "") String key_name,
            @PageableDefault(size = 6) Pageable pageable) {
        Page<Product> products = productService.getAllProduct(key_name, pageable);

        ModelAndView modelAndView = new ModelAndView("/product/listGroup");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Product product, Model model) {
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Product product,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        if (action.equals("down")) {
            cart.deleteProduct(product);
        }else {
            cart.addProduct(product);
        }
        return "redirect:/cart/shoppingCart";
    }


    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable("id") Product product,
                            @ModelAttribute Cart cart) {
            cart.deleteOneProductType(product);
        return "redirect:/cart/shoppingCart";
    }

    @GetMapping("/createCartData")
    public String createCartData(@ModelAttribute Cart cart) {
        CartData cartData = new CartData();
            cart.getProducts().entrySet().forEach(s -> {
                cartData.setProduct(s.getKey());
                cartData.setQuality(s.getValue());
                cartDataRepository.save(cartData);
            });
    return "redirect:/cart/shoppingCart";
    }
}
