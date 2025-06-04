package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.model.RegisterViewModel;
import kr.hhp227.springboot.model.User;
import kr.hhp227.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    UserService userService;

    @GetMapping("Login")
    public String login() {
        return "account/login";
    }

    @RequestMapping("Register")
    public String register() {
        return "account/register";
    }

    @RequestMapping("RegisterProcess")
    public String registerProcess(
            @Valid
            @ModelAttribute("RegisterViewModel")
            RegisterViewModel model,
            BindingResult bindingResult,
            User user,
            ModelMap modelMap
    ) {
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));

        if (bindingResult.hasErrors()) {
            List<String> prioritizedMessages = extractPrioritizedErrors(model); // addErrors
            modelMap.addAttribute("prioritizedErrors", prioritizedMessages);
            return "account/register";
        }
        userService.registerUser(user);
        return "redirect:/";
    }

    // 임시 로그아웃
    // post요청에 csrf보내야함?
    @RequestMapping("/Account/LogOff")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }

    private List<String> extractPrioritizedErrors(RegisterViewModel model) {
        List<String> messages = new ArrayList<>();

        if (model.getUsername() == null || model.getUsername().isEmpty()) {
            messages.add("사용자 이름 필드가 필요합니다.");
        }
        if (model.getPassword() == null || model.getPassword().isEmpty()) {
            messages.add("암호 필드가 필요합니다.");
        } else if (model.getPassword().length() < 6) {
            messages.add("암호은(는) 6자 이상이어야 합니다.");
        }
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            messages.add("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
        return messages;
    }
}
