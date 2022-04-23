package com.super15.quiz.service;

import com.super15.quiz.dto.request.LoginRequest;
import com.super15.quiz.dto.response.LoginResponse;
import com.super15.quiz.model.User;
import com.super15.quiz.repository.UserRepository;
import com.super15.quiz.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        if (validateLoginRequest(loginRequest)) {
            User user = userRepository.findByUserName(loginRequest.getUserName());
            if (user != null
                    && user.getPassword() != null
                    && user.getPassword().equals(loginRequest.getPassword())) {
                loginResponse.setFailureReason(Optional.of(" "));
                loginResponse.setHttpStatus(HttpStatus.OK);
                loginResponse.setMessage("Able To Login");
            } else {
                loginResponse.setFailureReason(Optional.of("Password Did Not Match"));
                loginResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                loginResponse.setMessage("Failed To Login");
                ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse,
                        HttpStatus.NOT_FOUND);

                return responseEntity;
            }
        } else {
            loginResponse.setFailureReason(Optional.of("Either User Name or Password is null"));
            loginResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            loginResponse.setMessage("Failed To Login");
            ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse,
                    HttpStatus.NOT_FOUND);

            return responseEntity;
        }
        String jwtString = jwtUtil.createJwtToken(loginRequest.getUserName(), loginRequest.getPassword());
        loginResponse.setJwtToken(jwtString);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("jwtToken", jwtString);
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(loginResponse);
    }

    private boolean validateLoginRequest(LoginRequest loginRequest) {
        if (loginRequest != null && loginRequest.getPassword() != null
                && loginRequest.getUserName() != null) {
            return true;
        }
        return false;
    }

}
