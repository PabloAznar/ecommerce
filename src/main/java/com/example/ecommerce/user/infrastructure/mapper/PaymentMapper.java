package com.example.ecommerce.user.infrastructure.mapper;

import com.example.ecommerce.user.domain.payment.Payment;
import com.example.ecommerce.user.domain.payment.dto.PaymentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    List<PaymentDto> toDtos(List<Payment> payments);

    PaymentDto toDto(Payment payment);
}
