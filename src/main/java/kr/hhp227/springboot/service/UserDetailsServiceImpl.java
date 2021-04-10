package kr.hhp227.springboot.service;

import kr.hhp227.springboot.domain.User;
import kr.hhp227.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUser(username);

        user.setAuthorities(getAuthorities(username));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.getAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String authority : string_authorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }
}
