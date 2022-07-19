package com.example.demo.application;

import com.example.demo.domain.Services.CustomerService;
import com.example.demo.domain.Services.OderService;
import com.example.demo.infrastructure.dto.CustomerDto;
import com.example.demo.infrastructure.dto.OderDto;
import com.example.demo.infrastructure.entity.Oder;
import com.example.demo.infrastructure.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("oder")
public class OderController {
    @Autowired
    OderService oderService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/create/{id}")
    public String showCreate(@PathVariable("id") Product product, Model model) {
        OderDto oderDto =  new OderDto();
        oderDto.setProductName(product.getName());
        oderDto.setProductPrice(product.getPrice());
        model.addAttribute("oderDto", oderDto);
        return "/oder/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("oderDto") OderDto oderDto,
                         BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors() ) {
            return "/oder/create";
        }else {
            CustomerDto customerDto = new CustomerDto(
                    oderDto.getCustomerName(),
                    oderDto.getCustomerPhone(),
                    oderDto.getCustomerAddress());
            customerService.save(customerDto);

            oderDto.setTotalPrice(oderDto.getQuantity() * oderDto.getProductPrice());
            oderService.save(oderDto);
            return "redirect:/product/list";
        }
    }

    // -------------------------------------------------------------------------------------- list --
    @GetMapping("/list")
    public String getList(Model model) {
        try {
            List<Oder> oders = oderService.getList();
            model.addAttribute("oders", oders);
            return "/oder/list";
        }
        catch (Exception e) {
            return "redirect:/";
        }
    }

    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Oder oder) {
        oderService.delete(oder);
        return "redirect:/oder/list";
    }
}
