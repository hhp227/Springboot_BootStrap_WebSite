package kr.hhp227.springboot.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

import kr.hhp227.springboot.domain.User;

public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthorities(String username);

    User getUser(String username);

    void addUser(User user);

    void removeUser(String username);

    PasswordEncoder passwordEncoder();
}
