package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.model.IndexViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    @RequestMapping("Manage")
    public String manage(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();
        IndexViewModel viewModel = new IndexViewModel();

        viewBag.put("Title", "Manage");
        viewModel.setHasPassword(true);
        viewModel.setTwoFactor(false);
        modelMap.addAttribute("ViewBag", viewBag);
        modelMap.addAttribute("IndexViewModel", viewModel);
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
