package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.mapper.HomeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    HomeMapper homeMapper;

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Home Page");
        modelMap.addAttribute("ViewBag", viewBag);
        return "home/home";
    }

    @RequestMapping("About")
    public String about(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "About");
        viewBag.put("Message", "Your application description page.");
        modelMap.addAttribute("ViewBag", viewBag);
        return "home/about";
    }

    @RequestMapping("Contact")
    public String contact(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Contact");
        viewBag.put("Message", "Your contact page.");
        modelMap.addAttribute("ViewBag", viewBag);
        return "home/contact";
    }
}
