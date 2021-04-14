package kr.hhp227.springboot.controller;

import kr.hhp227.springboot.domain.User;
import kr.hhp227.springboot.mapper.HomeMapper;
import kr.hhp227.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    HomeMapper homeMapper;

    @Autowired
    UserService userService;

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

    @RequestMapping("RegisterProcess")
    public String registerProcess(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));

        userService.removeUser(user.getUsername());
        userService.registerUser(user);
        User user1 = userService.getUser(user.getUsername());
        System.out.println(user1.getUsername());

        PasswordEncoder passwordEncoder = userService.getPasswordEncoder();
        System.out.println(passwordEncoder.matches(password, user1.getPassword()));

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        Collection<GrantedAuthority> authorities1 = (Collection<GrantedAuthority>) user1.getAuthorities();
        while (iterator.hasNext()) {
            GrantedAuthority authority = iterator.next();
            System.out.println(authorities1 + "" + new SimpleGrantedAuthority((authority.getAuthority())));
        }
        System.out.println("registerProcess");
        return "redirect:/";
    }
}
