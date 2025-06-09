package kr.hhp227.springboot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ForgotPasswordViewModel {
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
