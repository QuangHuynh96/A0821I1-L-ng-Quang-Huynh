package codegym.controller;

import codegym.entity.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("/email")
public class EmailBoxController {
    public static List languages = new ArrayList();
    static {
        languages.add("english");
        languages.add("vietnamese");
        languages.add("japanese");
        languages.add("chinese");
    }
    public static  List pageSizes = new ArrayList();
    static {
        pageSizes.add("5");
        pageSizes.add("10");
        pageSizes.add("15");
        pageSizes.add("25");
        pageSizes.add("50");
        pageSizes.add("100");
    }

    public static EmailConfig emailConfig;

    @GetMapping()
    public String doIndex(Model model) {
//        if(emailConfig == null) {
//            //set demo
//            emailConfig =  new EmailConfig("english","25",false, "Thor king, king, Asgard");
//        }
        model.addAttribute("emailConfig",emailConfig);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("languages", languages);
        model.addAttribute("updateEmailConfig", new EmailConfig() );
        return "view/index";
    }
    @PostMapping()
    public String update(@ModelAttribute("updateEmailConfig") EmailConfig updateEmailConfig) {
        emailConfig = updateEmailConfig;
        return "redirect:/view/index";
    }
}
