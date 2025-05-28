package kr.hhp227.springboot.model;

import javax.validation.constraints.NotBlank;

public class LoginViewModel {
    @NotBlank(message = "사용자 이름 필드가 필요합니다.")
    private String username;

    @NotBlank(message = "암호 필드가 필요합니다.")
    private String password;

    private boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginViewModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
