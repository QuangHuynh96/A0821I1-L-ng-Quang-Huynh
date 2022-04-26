package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwictCondimentController {
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        List<String> condimentList = new ArrayList<>();
        for (String condiment : condiments) {
            condimentList.add(condiment);
        }
model.addAttribute("condimentList", condimentList);
        return "view/list";
    }

}
