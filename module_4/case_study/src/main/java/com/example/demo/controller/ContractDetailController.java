package com.example.demo.controller;

import com.example.demo.dto.DtoContract;
import com.example.demo.dto.DtoContractDetail;
import com.example.demo.service.AttachServiceDAO;
import com.example.demo.service.ContractDetailService;
import com.example.demo.service.ContractService;
import com.example.demo.validator.ContractDetailValidator;
import com.example.demo.validator.ContractValidator;
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
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;

    @Autowired
    ContractService contractService;

    @Autowired
    AttachServiceDAO attachServiceDAO;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoContractDetail", new DtoContractDetail());
        model.addAttribute("contracts", contractService.getList());
        model.addAttribute("attachServices", attachServiceDAO.getList());
        return "/contractDetail/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("dtoContractDetail") @Validated DtoContractDetail dtoContractDetail,
                         BindingResult bindingResult,
                         Model model ) {
        new ContractDetailValidator().validate(dtoContractDetail, bindingResult);

        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("contracts", contractService.getList());
            model.addAttribute("attachServices", attachServiceDAO.getList());
            return "/contractDetail/create";
        }else {
            contractDetailService.save(dtoContractDetail);
            return "redirect:/";
        }
    }
    // -------------------------------------------------------------------------------------- list --

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contractDetails", contractDetailService.getList());
        return "/contractDetail/list";
    }
}
