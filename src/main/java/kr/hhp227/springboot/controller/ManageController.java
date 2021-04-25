package kr.hhp227.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {
    @RequestMapping("Manage")
    public String manage(ModelMap modelMap) {
        return "manage/index";
    }
}
