package com.example.demo.controller;

import com.example.demo.dto.DtoContract;
import com.example.demo.dto.DtoContractDetail;
import com.example.demo.entity.Contract;
import com.example.demo.entity.ContractDetail;
import com.example.demo.service.AttachServiceDAO;
import com.example.demo.service.ContractDetailService;
import com.example.demo.service.ContractService;
import com.example.demo.validator.ContractDetailValidator;
import com.example.demo.validator.ContractValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;

    @Autowired
    ContractService contractService;

    @Autowired
    AttachServiceDAO attachServiceDAO;

    @GetMapping("/create/{id}")
    public String showCreate(@PathVariable("id") Contract contract,Model model) {
        DtoContractDetail dtoContractDetail = new DtoContractDetail();
        dtoContractDetail.setContract(contract);

        model.addAttribute("dtoContractDetail", dtoContractDetail);
        model.addAttribute("attachServices", attachServiceDAO.getList());
        return "/contractDetail/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("dtoContractDetail") @Validated DtoContractDetail dtoContractDetail,
                         BindingResult bindingResult,
                         Model model ) {
        new ContractDetailValidator().validate(dtoContractDetail, bindingResult);

        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("attachServices", attachServiceDAO.getList());
            return "/contractDetail/create";
        }else {
            contractDetailService.save(dtoContractDetail);
            return "redirect:/contract/list";
        }
    }
    // -------------------------------------------------------------------------------------- list --

    @GetMapping("/list/{id}")
    public String list(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contractDetails", contractDetailService.getList(id));
        model.addAttribute("contractId", id);
        return "/contractDetail/list";
    }


    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") ContractDetail contractDetail) {
        List<ContractDetail> contractDetails = contractDetail.getContract().getContractDetails();
        contractDetails.remove(contractDetail);
        Contract contract = contractDetail.getContract();
        contract.setContractDetails(contractDetails);

        DtoContract dtoContract = new DtoContract();
        BeanUtils.copyProperties(contract, dtoContract);
        contractService.save(dtoContract);

        contractDetailService.delete(contractDetail);

        return "redirect:/contract/list";
    }


    // -------------------------------------------------------------------------------------- update --
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") ContractDetail contractDetail, Model model) {
        DtoContractDetail dtoContractDetail = new DtoContractDetail();

        BeanUtils.copyProperties(contractDetail, dtoContractDetail);
        model.addAttribute("dtoContractDetail",dtoContractDetail);

        model.addAttribute("attachServices", attachServiceDAO.getList());
        return "/contractDetail/create";
    }
}
