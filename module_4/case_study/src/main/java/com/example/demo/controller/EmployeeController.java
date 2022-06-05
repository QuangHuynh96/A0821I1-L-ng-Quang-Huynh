package com.example.demo.controller;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.dto.DtoEmployee;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    UserService userService;

    // ------------------------------------------------------------------------------------ create --
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoEmployee", new DtoEmployee());
        model.addAttribute("positions", positionService.getList());
        model.addAttribute("divisions", divisionService.getList());
        model.addAttribute("educationDegrees", educationDegreeService.getList());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("dtoEmployee") @Validated DtoEmployee dtoEmployee,
                         BindingResult bindingResult,
                         Model model ) {
        employeeService.save(dtoEmployee);
        return "redirect:/employee/create";
    }

}
