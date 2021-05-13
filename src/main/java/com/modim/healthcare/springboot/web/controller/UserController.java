package com.modim.healthcare.springboot.web.controller;

import com.modim.healthcare.springboot.domain.user.User;
import com.modim.healthcare.springboot.domain.user.UserRepository;
import com.modim.healthcare.springboot.service.UserService;
import com.modim.healthcare.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/api/moa/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/api/moa/findUserByEmail/{email}")
    public UserFindByEmailResponseDto findUserByEmail(@PathVariable String email)
    {
        return userService.findUserByEmail(email);
    }

    @GetMapping("api/moa/getAllUser")
    public List<User> getAllUsers(){
        List<User> listUser = new ArrayList<User>();
        return listUser = userRepository.findAll();
    }

    @GetMapping("api/moa/checkIfUserExists/{email}")
    public CheckUserExistsResponseDto checkAvailableEmail(@PathVariable String email){
        return userService.checkAvailableEmail(email);
    }

    @GetMapping("api/moa/deleteAllUser")
    public void deleteAllUser(){
        userRepository.deleteAll();
    }

    @GetMapping("api/moa/deleteUserByEmail")
    public String deleteUserByEmail(@PathVariable String email){
        return userService.deleteUserByEmail(email);
    }

    @PostMapping("api/moa/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        String email = userService.saveUser(userSaveRequestDto);
        return new ResponseEntity<User>(userSaveRequestDto.toEntity(), HttpStatus.OK);
    }

    @PutMapping("/api/moa/updateUser/{email}")
    public UserUpdateRequestDto updateUser(@PathVariable String email, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return userService.updateUser(email, userUpdateRequestDto);
    }

    @PutMapping("api/moa/loginUser")
    public ResponseEntity<LoginUserResponseDto> loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto)
    {
        return userService.loginUser(loginUserRequestDto);
    }

}
