package com.super15.quiz.controller;

import com.super15.quiz.dto.request.AuthenticationRequest;
import com.super15.quiz.dto.request.RegisterRequest;
import com.super15.quiz.dto.response.AuthenticationResponse;
import com.super15.quiz.dto.request.LoginRequest;
import com.super15.quiz.dto.response.LoginResponse;
import com.super15.quiz.dto.response.RegisterResponse;
import com.super15.quiz.service.AuthenticateService;
import com.super15.quiz.service.LoginService;
import com.super15.quiz.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    AuthenticateService authenticateService;

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/login", consumes = { "application/json" },
            produces = {"application/json"})
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {

        return loginService.login(loginRequest);
    }

    @PostMapping(value = "/register", consumes = { "application/json" },
            produces = {"application/json"})
    public RegisterResponse register (@RequestBody RegisterRequest registerRequest) {

        return registerService.register(registerRequest);
    }

    @PostMapping(value = "/authenticate", consumes = { "application/json" },
            produces = {"application/json"})
    public AuthenticationResponse getJwtToken (@RequestBody AuthenticationRequest authenticationRequest) {
        return authenticateService.authenticate(authenticationRequest);
    }

}
