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
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/index";
    }

    @RequestMapping("Manage/ChangePassword")
    public String changePassword(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Change Password");
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/changePassword";
    }


    @RequestMapping("Manage/ManageLogins")
    public String manageLogins(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Manage your external logins");
        viewBag.put("StatusMessage", "");
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/manageLogins";
    }
}
