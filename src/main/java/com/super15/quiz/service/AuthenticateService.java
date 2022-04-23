package com.super15.quiz.service;

import com.super15.quiz.dto.request.AuthenticationRequest;
import com.super15.quiz.dto.response.AuthenticationResponse;
import com.super15.quiz.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateService {

    @Autowired
    JwtUtil jwtUtil;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        return new AuthenticationResponse(jwtUtil.createJwtToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
    }


    @Component
    public static class RegisterService {
    }
}
