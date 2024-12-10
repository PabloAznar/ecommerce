package com.example.ecommerce.shared.errorhandler;

import com.example.ecommerce.shared.exceptions.ECommerceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ECommerceException.class)
    public ResponseEntity<ErrorResponse> handleECommerceException(ECommerceException eCommerceException){
        return ResponseEntity.status(eCommerceException.getStatus())
                .body(new ErrorResponse(eCommerceException.getStatus().name(), eCommerceException.getStatus().value(), eCommerceException.getMessage()));
    }
}
