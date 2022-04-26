package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    @PostMapping
    public String caculator(@RequestParam("number1") int number1,
                            @RequestParam("number2") int number2,
                            @RequestParam("caculator") String caculator,
                            Model model) {
        int result = 0;
        switch (caculator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        model.addAttribute("result", result);
        return "view/list";
    }
}
