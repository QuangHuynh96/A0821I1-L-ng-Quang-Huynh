package com.example.demo.controller;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.dto.DtoService;
import com.example.demo.entity.Customer;
import com.example.demo.service.RentTypeService;
import com.example.demo.service.ServiceDAO;
import com.example.demo.service.ServiceTypeDAO;
import com.example.demo.validator.ServiceValidator;
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
@RequestMapping("service")
public class ServiceController {
    @Autowired
    ServiceDAO serviceDAO;

    @Autowired
    ServiceTypeDAO serviceTypeDAO;

    @Autowired
    RentTypeService rentTypeService;

    // ------------------------------------------------------------------------------------ create --
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("dtoService", new DtoService());
        model.addAttribute("rentTypes", rentTypeService.getList());
        model.addAttribute("serviceTypes", serviceTypeDAO.getList());
        return "/service/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("dtoService") @Validated DtoService dtoService,
                         BindingResult bindingResult,
                         Model model ) {
        new ServiceValidator().validate(dtoService,bindingResult);

        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypes", rentTypeService.getList());
            model.addAttribute("serviceTypes", serviceTypeDAO.getList());
            return "/service/create";
        }else {
            serviceDAO.save(dtoService);
            return "redirect:/";
        }
    }

    //-------------------------------------------------------------------------list--
    @GetMapping("/list")
    public String getList( @RequestParam(defaultValue = "") String key_name,
                           @RequestParam(defaultValue = "") String key_phoneNumber,
                           @RequestParam(defaultValue = "") String key_idCard,
                           @PageableDefault(size = 5) Pageable pageable,
                           Model model) {
//        Page<Service> services = (key_name, key_phoneNumber, key_idCard, pageable);
//        model.addAttribute("services", services);
        return "redirect:/";
    }

}
