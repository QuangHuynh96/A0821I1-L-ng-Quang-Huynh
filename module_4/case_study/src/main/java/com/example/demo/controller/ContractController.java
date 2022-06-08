package com.example.demo.controller;

import com.example.demo.dto.DtoContract;
import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ServiceDAO;
import com.example.demo.validator.ContractValidator;
import com.example.demo.validator.ServiceValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ServiceDAO serviceDAO;

    // ------------------------------------------------------------------------------------ create --
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoContract",new DtoContract());
        model.addAttribute("customers",customerService.getList());
        model.addAttribute("employees",employeeService.getList());
        model.addAttribute("services",serviceDAO.getAllService());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("dtoContract") @Validated DtoContract dtoContract,
                         BindingResult bindingResult,
                         Model model ) {
        new ContractValidator().validate(dtoContract, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("customers",customerService.getList());
            model.addAttribute("employees",employeeService.getList());
            model.addAttribute("services",serviceDAO.getAllService());
            return "/contract/create";
        }else {
            contractService.save(dtoContract);
            return "redirect:/contract/list";
        }
    }

    // -------------------------------------------------------------------------------------- list --

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contracts", contractService.getList());
        return "/contract/list";
    }

    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Contract contract) {
        contractService.delete(contract);
        return "redirect:/contract/list";
    }


    // -------------------------------------------------------------------------------------- update --
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Contract contract, Model model) {
        DtoContract dtoContract = new DtoContract();
        BeanUtils.copyProperties(contract, dtoContract);
        model.addAttribute("dtoContract",dtoContract);
        model.addAttribute("customers",customerService.getList());
        model.addAttribute("employees",employeeService.getList());
        model.addAttribute("services",serviceDAO.getAllService());
        return "/contract/create";
    }
}
