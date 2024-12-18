package com.example.ecommerce.user.domain.payment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDto {

    private String cardNumber;

    private LocalDate expirationDate;

    private String cvv;

}
