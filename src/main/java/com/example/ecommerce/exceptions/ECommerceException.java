package com.example.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class ECommerceException extends RuntimeException  {

    private HttpStatus status;

    public ECommerceException(ExceptionType type) {
        super(type.getMessage());
        status = type.getStatus();
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("status: %d %s\n" +
                "message: %s", status.value(), status.name(), getMessage());
    }

}
