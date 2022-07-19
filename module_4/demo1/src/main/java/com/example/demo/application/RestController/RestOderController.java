package com.example.demo.application.RestController;

import com.example.demo.infrastructure.entity.Oder;
import com.example.demo.domain.Services.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestOderController {

    @Autowired
    OderService oderService;

    @GetMapping("/oder/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Oder> getAllOder() {
        List<Oder> oders = oderService.getList();
        Oder oder = new Oder();
        oder.setTotalPrice(5000);
        oders.add(oder);
        return oders;
    }
}
