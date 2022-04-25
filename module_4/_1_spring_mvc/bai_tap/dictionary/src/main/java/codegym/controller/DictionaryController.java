package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class DictionaryController {
    public static final List<String> englishs = new ArrayList<>();
    public static final List<String> vietnams = new ArrayList<>();
    static {
        englishs.add("one");
        englishs.add("two");
        englishs.add("three");
        englishs.add("four");
        englishs.add("five");
        englishs.add("six");
        englishs.add("seven");
        englishs.add("eight");
        englishs.add("nice");
        englishs.add("ten");
    }
    static {
        vietnams.add("một");
        vietnams.add("hai");
        vietnams.add("ba");
        vietnams.add("bốn");
        vietnams.add("năm");
        vietnams.add("sáu");
        vietnams.add("bảy");
        vietnams.add("tám");
        vietnams.add("chín");
        vietnams.add("mười");
    }
    @GetMapping("/translate")
    public String convert(@RequestParam("english") String english,Model model){
        String result = "find not in dectionary";
        for (int i = 0; i < englishs.size(); i++) {
            if(englishs.get(i).equals( english.toLowerCase()) ) {
                result = vietnams.get(i);
                break;
            }
        }
        model.addAttribute("result",result);
//        model.addAttribute("english",english);
//        redirectAttributes.addFlashAttribute("result",result);
        return "/view/home";
    }
}
