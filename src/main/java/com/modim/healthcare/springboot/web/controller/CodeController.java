package com.modim.healthcare.springboot.web.controller;

import com.modim.healthcare.springboot.domain.code.LCode;
import com.modim.healthcare.springboot.domain.code.LCodeRepository;
import com.modim.healthcare.springboot.service.CodeService;
import com.modim.healthcare.springboot.web.dto.LCodeSaveRequestDto;
import com.modim.healthcare.springboot.web.dto.LCodeSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CodeController {

    private final CodeService codeService;
    private final LCodeRepository lCodeRepository;

    @PostMapping("/api/moa/addLCode/{email}")
    public ResponseEntity<LCodeSaveResponseDto> addLCode(@PathVariable String email, @RequestBody LCodeSaveRequestDto lCodeSaveRequestDto)
    {
        return new ResponseEntity<LCodeSaveResponseDto>(codeService.addLCode(email, lCodeSaveRequestDto), HttpStatus.OK);
    }

    @GetMapping("/api/moa/deleteAllLCode")
    public void deleteAllLCode(){
        lCodeRepository.deleteAll();
    }

    @GetMapping("/api/moa/getAllLCode")
    public List<LCode> getAllLCode(){
        List<LCode> lCodeList = new ArrayList<>();
        return  lCodeList = lCodeRepository.findAll();
    }

}
