package kr.hhp227.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.hhp227.springboot.model.User;

public interface UserService extends UserDetailsService {
    void registerUser(User user);

    void changePassword(String username, String oldPassword, String newPassword);

    void removeUser(String username);

    PasswordEncoder getPasswordEncoder();
}
