package com.modim.healthcare.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserRequestDto {

    private String email;
    private String pass;

    @Builder
    public LoginUserRequestDto(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }


}
