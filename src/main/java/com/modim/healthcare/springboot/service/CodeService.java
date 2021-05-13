package com.modim.healthcare.springboot.service;

import com.modim.healthcare.springboot.domain.code.LCode;
import com.modim.healthcare.springboot.domain.code.LCodeRepository;
import com.modim.healthcare.springboot.web.dto.LCodeSaveRequestDto;
import com.modim.healthcare.springboot.web.dto.LCodeSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CodeService {

    private final LCodeRepository lCodeRepository;

    @Transactional
    public LCodeSaveResponseDto addLCode(String email, LCodeSaveRequestDto lCodeSaveRequestDto){
        LCode savedLCode = lCodeRepository.save(lCodeSaveRequestDto.buildSaveEntity(email));
        return new LCodeSaveResponseDto(savedLCode);
    }
}
