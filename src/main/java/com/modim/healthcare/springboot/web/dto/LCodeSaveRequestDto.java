package com.modim.healthcare.springboot.web.dto;

import com.modim.healthcare.springboot.domain.code.LCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LCodeSaveRequestDto {

    private String l_code;
    private String l_code_nm;
    private String use_yn;

    @Builder
    public LCodeSaveRequestDto(String l_code, String l_code_nm, String use_yn) {
        this.l_code = l_code;
        this.l_code_nm = l_code_nm;
        this.use_yn = use_yn;
    }

    public LCode buildSaveEntity(String email)
    {
        return LCode.builder()
                .l_code(l_code)
                .l_code_nm(l_code_nm)
                .use_yn(use_yn)
                .modified_user_id(email)
                .created_user_id(email)
                .build();
    }

    public LCode toEntity(){
        return LCode.builder()
                .l_code(l_code)
                .l_code_nm(l_code_nm)
                .use_yn(use_yn)
                .build();
    }
}
