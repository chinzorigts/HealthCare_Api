package com.modim.healthcare.springboot.service;

import com.modim.healthcare.springboot.domain.user.User;
import com.modim.healthcare.springboot.domain.user.UserRepository;
import com.modim.healthcare.springboot.exception.UserAlreadyExistsException;
import com.modim.healthcare.springboot.exception.UserNotFoundException;
import com.modim.healthcare.springboot.utils.StaticStrings;
import com.modim.healthcare.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String saveUser(UserSaveRequestDto requestDto) {

        String user_email = requestDto.getEmail();

        //checking that user's email existing in database
        if(validateDuplciateEmail(user_email))
        {
            throw new UserAlreadyExistsException(StaticStrings.USER_ALREADY_EXISTS + " : " + user_email);
        }
        User savedUser = userRepository.save(requestDto.toEntity());
        return savedUser.getEmail();
    }

    @Transactional
    public UserUpdateRequestDto updateUser(String email, UserUpdateRequestDto userUpdateRequestDto){
        User user = getRegisteredUser(email);
        user.update(userUpdateRequestDto.getPass(), userUpdateRequestDto.getName()
                , userUpdateRequestDto.getBirthday(), userUpdateRequestDto.getPhonenumber()
                , userUpdateRequestDto.getSex(), userUpdateRequestDto.getHeight()
                , userUpdateRequestDto.getWeight(), email);

        User updatedUser = userRepository.findById(email).orElse(null);
        return  new UserUpdateRequestDto(updatedUser);
    }

    public UserFindByEmailResponseDto findUserByEmail(String email){
        User user = getRegisteredUser(email);
        return new UserFindByEmailResponseDto(user);
    }

    public CheckUserExistsResponseDto checkAvailableEmail(String email){
        User user = userRepository.findById(email).orElse(null);
        if(user != null)
        {
            throw new UserAlreadyExistsException(StaticStrings.USER_ALREADY_EXISTS + " : " + email);
        }
        return new CheckUserExistsResponseDto(HttpStatus.OK, HttpStatus.OK.value(), StaticStrings.SUCCESS, StaticStrings.SUCCESS_KR);
    }

    public boolean validateDuplciateEmail(String email)
    {
        return userRepository.findById(email).orElse(null) == null ? false : true;
    }

    public String deleteUserByEmail(String email)
    {
        getRegisteredUser(email);
        userRepository.deleteById(email);
        return email;
    }

    private User getRegisteredUser(String email){
        User user = userRepository.findById(email).orElse(null);
        if(user == null)
        {
            throw new UserNotFoundException(StaticStrings.USER_NOT_FOUND +" : " + email);
        }
        return user;
    }

    public ResponseEntity<LoginUserResponseDto> loginUser(LoginUserRequestDto loginUserRequestDto){
        User user = userRepository.findById(loginUserRequestDto.getEmail()).orElse(null);

        if(user == null || user.getPass().compareTo(loginUserRequestDto.getPass()) != 0)
        {
            return new ResponseEntity<>(new LoginUserResponseDto(HttpStatus.BAD_REQUEST, StaticStrings.FAIL, StaticStrings.ID_OR_PASS_NOT_SAME), HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>(new LoginUserResponseDto(HttpStatus.OK, StaticStrings.SUCCESS, StaticStrings.SUCCESS_KR), HttpStatus.OK)  ;
        }
    }
}
