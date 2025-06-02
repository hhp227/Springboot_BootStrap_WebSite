package kr.hhp227.springboot.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterViewModel {
    @NotBlank(message = "사용자 이름 필드가 필요합니다.")
    private String username;

    @NotBlank(message = "암호 필드가 필요합니다.")
    @Size(min = 6, message = "암호은(는) 6자 이상이어야 합니다.")
    private String password;

    @NotBlank
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterViewModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
