package kr.hhp227.springboot.mapper;

import kr.hhp227.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(String username);

    @Insert("Insert into users values (#{account.username},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
    void insertUser(@Param("account") User account);

    List<String> getAuthority(String username);
}
