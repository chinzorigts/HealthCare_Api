package com.modim.healthcare.springboot.web.dto;

import com.modim.healthcare.springboot.domain.code.LCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LCodeSaveResponseDto {

    private String l_code;
    private String l_code_nm;
    private String use_yn;

    private String modified_user_id;
    private String created_user_id;
    private LocalDateTime modified_date;
    private LocalDateTime created_date;

    @Builder
    public LCodeSaveResponseDto(LCode entity) {
        this.l_code = entity.getL_code();
        this.l_code_nm = entity.getL_code_nm();
        this.use_yn = entity.getUse_yn();
        this.modified_user_id = entity.getModified_user_id();
        this.created_user_id = entity.getCreated_user_id();
        this.modified_date = entity.getModified_date();
        this.created_date = entity.getCreated_date();
    }
}
