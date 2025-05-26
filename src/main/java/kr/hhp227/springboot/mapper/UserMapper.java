package kr.hhp227.springboot.mapper;

import kr.hhp227.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(String username);

    List<GrantedAuthority> getAuthority(String username);

    //@Insert("Insert into users values (#{account.username},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
    void addUser(/*@Param("account") */User user);

    void setUser(User user);

    void addAuthority(User user);

    void removeUser(String username);

    void removeAuthority(String username);
}
