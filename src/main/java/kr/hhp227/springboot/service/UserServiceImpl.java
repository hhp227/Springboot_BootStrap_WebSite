package kr.hhp227.springboot.service;

import com.sun.net.httpserver.Authenticator;
import kr.hhp227.springboot.model.User;
import kr.hhp227.springboot.mapper.UserMapper;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUser(username);

        user.setAuthorities(userMapper.getAuthority(username));
        return user;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        if (!username.isEmpty() && !password.isEmpty()) {
            if (userMapper.getUser(username) != null)
                return;
            user.setPassword(encodedPassword);
            userMapper.addUser(user);
            userMapper.addAuthority(user);
        }
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.getUser(username);

        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            String encodedNewPassword = passwordEncoder.encode(newPassword);

            user.setPassword(encodedNewPassword);
            userMapper.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void removeUser(String username) {
        userMapper.removeUser(username);
        userMapper.removeAuthority(username);
    }

    @Override
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
