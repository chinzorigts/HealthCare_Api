package com.modim.healthcare.springboot.web.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class CheckUserExistsResponseDto {

    //결과 스타토스
    private final HttpStatus httpStatus;
    //결과 코드
    private final int resultCode;
    //결과 코드 메시지
    private final String resultMessage;
    //결과 내용
    private final String resultDetail;
    //결과 시간
    private final LocalDateTime resultTime;

    public CheckUserExistsResponseDto(HttpStatus httpStatus, int resultCode, String resultMessage, String resultDetail, LocalDateTime resultTime) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultDetail = resultDetail;
        this.resultTime = resultTime;
    }

    public CheckUserExistsResponseDto(HttpStatus httpStatus, int resultCode, String resultMessage, String resultDetail) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultDetail = resultDetail;
        this.resultTime = LocalDateTime.now();
    }
}
