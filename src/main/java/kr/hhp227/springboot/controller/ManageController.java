package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.model.ChangePasswordViewModel;
import kr.hhp227.springboot.model.IndexViewModel;
import kr.hhp227.springboot.model.User;
import kr.hhp227.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Manage")
public class ManageController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public String manage(
            @RequestParam(value = "Message", required = false)
            String message,
            ModelMap modelMap
    ) {
        Map<String, String> viewBag = new HashMap<>();
        String statusMessage;
        IndexViewModel model = new IndexViewModel();

        viewBag.put("Title", "Manage");
        if (message != null) {
            statusMessage = message.equals("ChangePasswordSuccess") ? "Your password has been changed."
                    : message.equals("SetPasswordSuccess") ? "Your password has been set."
                    : message.equals("SetTwoFactorSuccess") ? "Your two-factor authentication provider has been set."
                    : message.equals("Error") ? "An error has occurred."
                    : message.equals("AddPhoneSuccess") ? "Your phone number was added."
                    : message.equals("RemovePhoneSuccess") ? "Your phone number was removed."
                    : "";

            viewBag.put("StatusMessage", statusMessage);
        }
        model.setHasPassword(true);
        model.setTwoFactor(false);
        modelMap.addAttribute("ViewBag", viewBag);
        modelMap.addAttribute("IndexViewModel", model);
        return "manage/index";
    }

    @RequestMapping("ChangePassword")
    public String changePassword(ModelMap modelMap) {
        Map<String, Object> viewBag = new HashMap<>();

        viewBag.put("Title", "Change Password");
        modelMap.addAttribute("ViewBag", viewBag);
        modelMap.addAttribute("ChangePasswordViewModel", new ChangePasswordViewModel());
        return "manage/changePassword";
    }

    @RequestMapping("ChangePasswordProcess")
    public String changePasswordProcess(
            @Valid
            @ModelAttribute("ChangePasswordViewModel")
            ChangePasswordViewModel model,
            BindingResult bindingResult,
            Principal principal,
            ModelMap modelMap
    ) {
        System.out.println("changePasswordProcess" + ", " + model.toString());
        User user = (User) userService.loadUserByUsername(principal.getName());

        if (!model.getNewPassword().equals(model.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "", "새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
        if (bindingResult.hasErrors()) {
            Map<String, Object> viewBag = new HashMap<>();

            viewBag.put("Title", "Change Password");
            modelMap.addAttribute("ViewBag", viewBag);
            modelMap.addAttribute("ChangePasswordViewModel", model);
            System.out.println("ChangePasswordProcessError" + "model: " + model);
            return "manage/changePassword";
        }
        if (user != null) {
            boolean isSuccess = userService.changePassword(user.getUsername(), model.getOldPassword(), model.getNewPassword());

            if (isSuccess) {
                return "redirect:/Manage?Message=ChangePasswordSuccess";
            }
        }
        return "manage/changePassword";
    }

    @RequestMapping("ManageLogins")
    public String manageLogins(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "Manage your external logins");
        viewBag.put("StatusMessage", "");
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/manageLogins";
    }
}
