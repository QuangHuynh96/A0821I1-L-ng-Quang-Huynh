package com.example.demo.controller;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerType;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import com.example.demo.validator.CustomerValidator;
import com.example.demo.validator.EmployeeValidator;
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
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    // ------------------------------------------------------------------------------------ create --
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoCustomer", new DtoCustomer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("dtoCustomer") @Validated DtoCustomer dtoCustomer,
                         BindingResult bindingResult,
                         Model model ) {

        new CustomerValidator().validate(dtoCustomer, bindingResult);

//        boolean checkIdCard = customerService.checkIdCard(dtoCustomer.getIdCard());
//        boolean checkId = customerService.checkId(dtoCustomer.getId());

        if(bindingResult.hasFieldErrors() ) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
//            model.addAttribute("checkIdCard", "ID đã tồn tại");
            return "/customer/create";
        }else {
            customerService.save(dtoCustomer);
            return "redirect:/customer/list";
        }
    }

    // -------------------------------------------------------------------------------------- list --
    @GetMapping("/list")
    public String getList( @RequestParam(defaultValue = "") String key_name,
                           @RequestParam(defaultValue = "") String key_phoneNumber,
                           @RequestParam(defaultValue = "") String key_idCard,
                           @PageableDefault(size = 5) Pageable pageable,
                           Model model) {
        try {
            Page<Customer> customers = customerService.getAllCustomer(key_name, key_phoneNumber, key_idCard, pageable);
            model.addAttribute("customers", customers);
            return "/customer/list";
        }
        catch (Exception e) {
            return "redirect:/";
        }
    }

    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Customer customer) {
       customerService.delete(customer);
       return "redirect:/customer/list";
    }


    // -------------------------------------------------------------------------------------- update --
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Customer customer, Model model) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        BeanUtils.copyProperties(customer, dtoCustomer);
        model.addAttribute("dtoCustomer", dtoCustomer);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/create";
    }
}
