package com.example.demo.controller;

import com.example.demo.dto.DtoUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(
            @RequestParam(defaultValue = "") String key_phoneNumber,
            @RequestParam(defaultValue = "") String key_email,
            @PageableDefault(size = 5) Pageable pageable,
            Model model) {
        Page<User> users = userService.getAllUser(key_phoneNumber, key_email, pageable);
        model.addAttribute("users", users);
        return "/user/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoUser", new DtoUser());
        return "/user/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("dtoUser") @Validated DtoUser dtoUser,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model ) {
        new DtoUser().validate(dtoUser , bindingResult);

        if(bindingResult.hasFieldErrors()) {
            return "/user/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(dtoUser, user);
            userService.save(user);
            return "redirect:/user/list";
        }

    }
}
