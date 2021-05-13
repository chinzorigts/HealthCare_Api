package com.modim.healthcare.springboot.web.dto;

import com.modim.healthcare.springboot.domain.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class UserFindByEmailResponseDto {

    private String email;
    private String pass;
    private String name;
    private String birthday;
    private String phonenumber;
    private String sex;
    private int height;
    private BigDecimal weight;
    private String created_user_id;
    private String modified_user_id;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public UserFindByEmailResponseDto() {
    }

    public UserFindByEmailResponseDto(User entity) {
        this.email = entity.getEmail();
        this.pass = entity.getPass();
        this.name = entity.getName();
        this.birthday = entity.getBirthday();
        this.phonenumber = entity.getPhonenumber();
        this.sex = entity.getSex();
        this.height = entity.getHeight();
        this.weight = entity.getWeight();
        this.created_user_id = entity.getCreated_user_id();
        this.modified_user_id = entity.getModified_user_id();
        this.created_date = entity.getCreated_date();
        this.modified_date = entity.getModified_date();
    }
}
