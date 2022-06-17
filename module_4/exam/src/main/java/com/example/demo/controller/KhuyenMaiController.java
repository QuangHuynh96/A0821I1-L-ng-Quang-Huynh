package com.example.demo.controller;

import com.example.demo.dto.KhuyenMaiDto;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.formatKhuyenMai;
import com.example.demo.service.KhuyenMaiService;
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
@RequestMapping("khuyenMai")
public class KhuyenMaiController {

    @Autowired
    KhuyenMaiService khuyenMaiService;

    // ------------------------------------------------------------------------------------ create --
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("khuyenMaiDto", new KhuyenMaiDto());
        return "/khuyenMai/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("khuyenMaiDto") @Validated KhuyenMaiDto khuyenMaiDto,
                         BindingResult bindingResult,
                         Model model ) {
        if (bindingResult.hasFieldErrors()) {
            return "/khuyenMai/create";
        } else {
            KhuyenMai khuyenMai = new formatKhuyenMai().format(khuyenMaiDto);
            khuyenMai.setFlag(true);
            khuyenMaiService.save(khuyenMai);
            model.addAttribute("message", "Thêm mới thành công!");
            return "/khuyenMai/create";
        }
    }


    // -------------------------------------------------------------------------------------- list --
    @GetMapping("/list")
    public String getList( @RequestParam(defaultValue = "0") int key_money,
                           @RequestParam(defaultValue = "") String key_startDay,
                           @RequestParam(defaultValue = "") String key_endDay,
                           @PageableDefault(size = 100) Pageable pageable,
                           Model model) {
        try {
            Page<KhuyenMai> khuyenMaiList = khuyenMaiService.getAllCustomer(key_money, key_startDay, key_endDay, pageable);
            model.addAttribute("khuyenMaiList", khuyenMaiList);
            return "/khuyenMai/list";
        }
        catch (Exception e) {
            return "redirect:/list";
        }
    }

    // --------------------------------------------------------------------------------------  delete --
    @PostMapping("/delete")
    public String delete(@RequestParam("id") KhuyenMai khuyenMai) {
        khuyenMaiService.delete(khuyenMai);
        return "redirect:/khuyenMai/list";
    }



    // -------------------------------------------------------------------------------------- list --
    @GetMapping("/search")
    public String search( @RequestParam(defaultValue = "1") int key_money,
                           @RequestParam(defaultValue = "") String key_startDay,
                           @RequestParam(defaultValue = "") String key_endDay,
                           @PageableDefault(size = 100) Pageable pageable,
                           Model model) {
        try {
            if(key_money == 1) {
                Page<KhuyenMai> khuyenMaiList = khuyenMaiService.getAllCustomer(key_money, key_startDay, key_endDay, pageable);
                model.addAttribute("khuyenMaiList", khuyenMaiList);
            }else {
                Page<KhuyenMai> khuyenMaiList = khuyenMaiService.search(key_money, key_startDay, key_endDay, pageable);
                model.addAttribute("khuyenMaiList", khuyenMaiList);
            }
            return "/khuyenMai/list";
        }
        catch (Exception e) {
            return "redirect:/list";
        }
    }
}
