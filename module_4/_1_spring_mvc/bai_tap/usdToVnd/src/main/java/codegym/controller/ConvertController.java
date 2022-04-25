package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String convert(@RequestParam("usd") double usd,@RequestParam("rate") double exchangeRate, Model model){
        double convert = usd*exchangeRate;
        model.addAttribute("convert",convert);
        return "view/convert";
    }
}
