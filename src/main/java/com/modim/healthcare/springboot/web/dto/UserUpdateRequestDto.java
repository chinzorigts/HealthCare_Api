package com.modim.healthcare.springboot.web.dto;

import com.modim.healthcare.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String pass;
    private String name;
    private String birthday;
    private String phonenumber;
    private String sex;
    private int height;
    private BigDecimal weight;

    private String modified_user_id;
    private LocalDateTime modified_date;

    @Builder
    public UserUpdateRequestDto(String pass, String name, String birthday, String phonenumber, String sex, int height, BigDecimal weight) {
        this.pass = pass;
        this.name = name;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.modified_date = LocalDateTime.now();
    }

    @Builder
    public UserUpdateRequestDto(User entity) {
        this.pass = entity.getPass();
        this.name = entity.getName();
        this.birthday = entity.getBirthday();
        this.phonenumber = entity.getPhonenumber();
        this.sex = entity.getSex();
        this.height = entity.getHeight();
        this.weight = entity.getWeight();
        this.modified_user_id = entity.getModified_user_id();
        this.modified_date = entity.getModified_date();
    }
}
