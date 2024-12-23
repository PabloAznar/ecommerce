package com.example.ecommerce.shared.domain.errorhandler.exceptions;

import org.springframework.http.HttpStatus;

public class ECommerceException extends RuntimeException  {

    private HttpStatus status;

    public ECommerceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
