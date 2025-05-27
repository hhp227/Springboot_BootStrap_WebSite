package kr.hhp227.springboot.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePasswordViewModel {
    @NotBlank(message = "현재 비밀번호를 입력하세요.")
    private String oldPassword;

    @NotBlank(message = "새 비밀번호를 입력하세요.")
    @Size(min = 6, message = "새 비밀번호는 최소 6자 이상이어야 합니다.")
    private String newPassword;

    @NotBlank(message = "새 비밀번호 확인을 입력하세요.")
    private String confirmPassword;

    // Getters and Setters
    public String getOldPassword() { return oldPassword; }

    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getNewPassword() { return newPassword; }

    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getConfirmPassword() { return confirmPassword; }

    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    @Override
    public String toString() {
        return "ChangePasswordViewModel{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
