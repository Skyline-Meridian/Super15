package com.super15.quiz.service;

import com.super15.quiz.dto.request.RegisterRequest;
import com.super15.quiz.dto.response.LoginResponse;
import com.super15.quiz.dto.response.RegisterResponse;
import com.super15.quiz.model.User;
import com.super15.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        if (isUserExistByNameBefore(registerRequest)) {
            registerResponse.setAbleToRegister(Boolean.FALSE);
            registerResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            registerResponse.setMessage("Same user exists already");
            return registerResponse;
        }
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRole(registerRequest.getRole());
        registerResponse.setAbleToRegister(Boolean.TRUE);
        registerResponse.setHttpStatus(HttpStatus.OK);
        registerResponse.setMessage("User Registered Succesfully");
        return registerResponse;
    }

    private boolean isUserExistByNameBefore(RegisterRequest registerRequest) {
        return userRepository.findByName(registerRequest.getUserName()).isPresent();
    }
}
