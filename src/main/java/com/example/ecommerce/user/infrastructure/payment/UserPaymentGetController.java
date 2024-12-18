package com.example.ecommerce.user.infrastructure.payment;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.payment.find.UserPaymentFinder;
import com.example.ecommerce.user.domain.payment.Payment;
import com.example.ecommerce.user.domain.payment.dto.PaymentDto;
import com.example.ecommerce.user.infrastructure.mapper.AddressMapper;
import com.example.ecommerce.user.infrastructure.mapper.PaymentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPaymentGetController {

    private final UserPaymentFinder paymentFinder;

    PaymentMapper MAPPER = Mappers.getMapper( PaymentMapper.class );

    public UserPaymentGetController(UserPaymentFinder paymentFinder) {
        this.paymentFinder = paymentFinder;
    }

    @GetMapping(Constants.API_BASE_PATH + "/users/{userId}/payments")
    public List<PaymentDto> findPaymentsByUser(@PathVariable("userId") final String userId) {
        return MAPPER.toDtos(paymentFinder.getPayments(userId));
    }

}
