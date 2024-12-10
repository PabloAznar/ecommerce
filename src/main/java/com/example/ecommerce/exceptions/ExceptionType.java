package com.example.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

public enum ExceptionType {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    OPERATION_NOT_SUPPORTED(HttpStatus.BAD_REQUEST, "SQL Operation provided not supported by criteria");

    private HttpStatus status;
    private String message;

    ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
