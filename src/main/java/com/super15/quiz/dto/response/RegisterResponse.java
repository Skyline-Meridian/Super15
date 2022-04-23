package com.super15.quiz.dto.response;

import org.springframework.http.HttpStatus;

public class RegisterResponse {
    private String message;

    private HttpStatus httpStatus;

    private boolean isAbleToRegister;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isAbleToRegister() {
        return isAbleToRegister;
    }

    public void setAbleToRegister(boolean ableToRegister) {
        isAbleToRegister = ableToRegister;
    }
}
