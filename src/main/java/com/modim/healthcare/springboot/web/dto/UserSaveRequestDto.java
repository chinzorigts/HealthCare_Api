package com.modim.healthcare.springboot.web.dto;

import com.modim.healthcare.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String pass;
    private String name;
    private String birthday;
    private String phonenumber;
    private String sex;
    private int height;
    private BigDecimal weight;

    @Builder
    public UserSaveRequestDto(String email, String pass, String name, String birthday, String phonenumber, String sex, int height, BigDecimal weight) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public User toEntity()
    {
        return  User.builder()
                .email(email)
                .name(name)
                .birthday(birthday)
                .phonenumber(phonenumber)
                .pass(pass)
                .height(height)
                .sex(sex)
                .weight(weight)
                .build();
    }
}
