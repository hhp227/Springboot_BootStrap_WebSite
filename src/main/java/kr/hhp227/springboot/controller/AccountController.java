package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.model.ChangePasswordViewModel;
import kr.hhp227.springboot.model.LoginViewModel;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    UserService userService;

    @GetMapping("Login")
    public String login(ModelMap modelMap) {
        Map<String, Object> viewBag = new HashMap<>();

        viewBag.put("Title", "로그인");
        modelMap.addAttribute("ViewBag", viewBag);
        modelMap.addAttribute("LoginViewModel", new LoginViewModel());
        return "account/login";
    }

    @RequestMapping("Register")
    public String register(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "등록");
        modelMap.addAttribute("ViewBag", viewBag);
        modelMap.addAttribute("RegisterViewModel", new RegisterViewModel());
        return "account/register";
    }

    @RequestMapping("RegisterProcess")
    public String registerProcess(
            @Valid
            @ModelAttribute("RegisterViewModel")
            RegisterViewModel model,
            BindingResult bindingResult,
            User user
    ) {
        System.out.println("registerProcess: " + model);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "비밀번호가 일치하지 않습니다.");
        }

        if (bindingResult.hasErrors()) {
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
}
