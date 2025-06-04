package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.model.ChangePasswordViewModel;
import kr.hhp227.springboot.model.IndexViewModel;
import kr.hhp227.springboot.model.RegisterViewModel;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public String changePassword() {
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

        if (bindingResult.hasErrors()) {
            List<String> prioritizedMessages = extractPrioritizedErrors(model); // addErrors
            modelMap.addAttribute("prioritizedErrors", prioritizedMessages);
            modelMap.addAttribute("ChangePasswordViewModel", model);
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
    public String manageLogins(
            @RequestParam(value = "Message", required = false)
            String message,
            ModelMap modelMap
    ) {
        Map<String, String> viewBag = new HashMap<>();
        String statusMessage;

        if (message != null) {
            statusMessage = message.equals("RemoveLoginSuccess") ? "The external login was removed."
                    : message.equals("Error") ? "An error has occurred."
                    : "";

            viewBag.put("StatusMessage", statusMessage);
        }
        modelMap.addAttribute("ViewBag", viewBag);
        return "manage/manageLogins";
    }

    private List<String> extractPrioritizedErrors(ChangePasswordViewModel model) {
        List<String> messages = new ArrayList<>();

        if (model.getOldPassword() == null || model.getOldPassword().isEmpty()) {
            messages.add("Current password 필드가 필요합니다.");
        }
        if (model.getNewPassword() == null || model.getNewPassword().isEmpty()) {
            messages.add("New password 필드가 필요합니다.");
        } else if (model.getNewPassword().length() < 6) {
            messages.add("암호은(는) 6자 이상이어야 합니다.");
        }
        if (!model.getNewPassword().equals(model.getConfirmPassword())) {
            messages.add("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
        // Incorrect password. 처리
        return messages;
    }
}
