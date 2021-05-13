package com.modim.healthcare.springboot.domain.code;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "tbl_l_code")
public class LCode {

    @Id
    @Column(length = 2)
    private String l_code;

    @Column(length = 100, nullable = false)
    private String l_code_nm;

    @Column(length = 1, nullable = false)
    private String use_yn;

    @Column(length = 50)
    private String modified_user_id;

    @Column(length = 50)
    private String created_user_id;

    private LocalDateTime modified_date;

    private LocalDateTime created_date;

    @Builder
    public LCode(String l_code, String l_code_nm, String use_yn, String modified_user_id, String created_user_id) {
        this.l_code = l_code;
        this.l_code_nm = l_code_nm;
        this.use_yn = use_yn;
        this.modified_user_id = modified_user_id;
        this.created_user_id = created_user_id;
        this.modified_date = LocalDateTime.now();
        this.created_date = LocalDateTime.now();
    }
}
