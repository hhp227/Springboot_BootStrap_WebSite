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

    @RequestMapping("About")
    public String about(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "About");
        viewBag.put("Message", "Your application description page.");
        modelMap.addAttribute("ViewBag", viewBag);
        return "about";
    }

    @RequestMapping("Contact")
    public String contact(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Contact");
        viewBag.put("Message", "Your contact page.");
        modelMap.addAttribute("ViewBag", viewBag);
        return "contact";
    }

    @RequestMapping("Login")
    public String login(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "로그인");
        modelMap.addAttribute("ViewBag", viewBag);
        return "login";
    }

    @RequestMapping("Register")
    public String register(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "등록");
        modelMap.addAttribute("ViewBag", viewBag);
        return "register";
    }
}
