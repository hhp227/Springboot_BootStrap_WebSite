package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.domain.User;
import kr.hhp227.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    UserService userService;

    @RequestMapping("Login")
    public String login(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "로그인");
        modelMap.addAttribute("ViewBag", viewBag);
        return "account/login";
    }

    @RequestMapping("Register")
    public String register(ModelMap modelMap) {
        Map<String, String> viewBag = new HashMap<>();

        viewBag.put("Title", "등록");
        modelMap.addAttribute("ViewBag", viewBag);
        return "account/register";
    }

    @RequestMapping("RegisterProcess")
    public String registerProcess(User user) {
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
        userService.registerUser(user);
        /*User user1 = userService.getUser(user.getUsername());
        System.out.println(user1.getUsername());

        PasswordEncoder passwordEncoder = userService.getPasswordEncoder();
        System.out.println(passwordEncoder.matches(user.getPassword(), user1.getPassword()));

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        Collection<GrantedAuthority> authorities1 = (Collection<GrantedAuthority>) user1.getAuthorities();
        while (iterator.hasNext()) {
            GrantedAuthority authority = iterator.next();
            System.out.println(authorities1 + "" + new SimpleGrantedAuthority((authority.getAuthority())));
        }
        System.out.println("registerProcess");*/
        return "account/login";
    }

    // 임시 로그아웃
    // post요청에 csrf보내야함?
    @RequestMapping("/Logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }
}
