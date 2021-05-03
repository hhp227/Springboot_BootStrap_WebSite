package kr.hhp227.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ManageController {
    @RequestMapping("Manage")
    public String manage(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Manage");
        viewBag.put("StatusMessage", "Temp");
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/index";
    }
}
