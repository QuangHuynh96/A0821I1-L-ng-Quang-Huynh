package com.example.demo.controller;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.service.*;
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
//        new DtoEmployee().validate(dtoEmployee, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "/employee/create";
        }else {
            employeeService.save(dtoEmployee);
            return "redirect:/employee/list";
        }
    }

    // ------------------------------------------------------------------------------------ list --
    @GetMapping("/list")
    public String getList( @RequestParam(defaultValue = "") String key_name,
                           @RequestParam(defaultValue = "") String key_phoneNumber,
                           @RequestParam(defaultValue = "") String key_idCard,
                           @RequestParam(defaultValue = "") String key_email,
                           @PageableDefault(size = 5) Pageable pageable,
                           Model model) {
        Page<Employee> employees = employeeService.getAllEmployee(key_name, key_phoneNumber, key_idCard, key_email, pageable);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }


    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Employee employee) {
        employeeService.delete(employee);
        return "redirect:/employee/list";
    }


    // -------------------------------------------------------------------------------------- update --
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Employee employee, Model model) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        BeanUtils.copyProperties(employee, dtoEmployee);
        model.addAttribute("dtoEmployee", dtoEmployee);
        model.addAttribute("positions", positionService.getList());
        model.addAttribute("divisions", divisionService.getList());
        model.addAttribute("educationDegrees", educationDegreeService.getList());
        return "/employee/create";
    }
}
