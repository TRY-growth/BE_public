package com.example.TRYBE.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String passwordConfirm;

    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickname;

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .nickname(this.nickname)
                .build();
    }
}
