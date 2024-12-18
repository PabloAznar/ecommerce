package com.example.ecommerce.user.infrastructure.payment;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.payment.create.UserPaymentCreator;
import com.example.ecommerce.user.domain.payment.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserPaymentPutController {

    private final UserPaymentCreator paymentCreator;

    public UserPaymentPutController(UserPaymentCreator paymentCreator) {
        this.paymentCreator = paymentCreator;
    }

    @PutMapping(path = Constants.API_BASE_PATH + "/users/{userId}/payments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUserPayment(@PathVariable("userId") final String userId, @RequestBody Payment payment) {
        paymentCreator.addPayment(payment, userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
