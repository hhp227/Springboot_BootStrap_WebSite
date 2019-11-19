package kr.hhp227.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();
        viewBag.put("Title", "Home Page");
        modelMap.addAttribute("ViewBag", viewBag);
        return "home";
    }
}
