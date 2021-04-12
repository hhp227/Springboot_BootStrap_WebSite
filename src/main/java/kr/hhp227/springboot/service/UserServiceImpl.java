package kr.hhp227.springboot.service;

import kr.hhp227.springboot.domain.User;
import kr.hhp227.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUser(username);

        user.setAuthorities(getAuthorities(username));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(String username) {
        return userMapper.getAuthority(username);
    }

    @Override
    public User getUser(String username) {
        User user = userMapper.getUser(username);

        user.setAuthorities(userMapper.getAuthority(username));
        return user;
    }

    @Override
    public void addUser(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        user.setPassword(encodedPassword);
        userMapper.addUser(user);
        userMapper.addAuthority(user);
    }

    @Override
    public void removeUser(String username) {
        userMapper.removeUser(username);
        userMapper.removeAuthority(username);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }
}
