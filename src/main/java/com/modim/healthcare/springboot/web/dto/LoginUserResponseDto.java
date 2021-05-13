package com.modim.healthcare.springboot.web.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class LoginUserResponseDto {

    //결과 스타토스
    private final HttpStatus httpStatus;
    //결과 코드
    private final int resultCode;
    //결과 코드 메시지
    private final String resultMessage;
    //결과 내용
    private final String resultDetail;
    //결과 시간
    private final LocalDateTime lastLogTime;

    public LoginUserResponseDto(HttpStatus httpStatus, String resultMessage, String resultDetail) {
        this.httpStatus = httpStatus;
        this.resultCode = httpStatus.value();
        this.resultMessage = resultMessage;
        this.resultDetail = resultDetail;
        this.lastLogTime = LocalDateTime.now();
    }
}
