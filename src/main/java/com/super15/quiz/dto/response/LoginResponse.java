package com.super15.quiz.dto.response;

import org.springframework.http.HttpStatus;

import java.util.Optional;

public class LoginResponse {

    HttpStatus httpStatus;

    String Message;

    Optional<String> failureReason;

    String jwtToken;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Optional<String> getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(Optional<String> failureReason) {
        this.failureReason = failureReason;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
