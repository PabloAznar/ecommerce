package com.example.ecommerce.user.application.payment.find;

import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.domain.payment.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentFinder {

    private final UserRepository userRepository;

    public UserPaymentFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Payment> getPayments(final String userId) {
        return userRepository.findPaymentsByUser(userId);
    }

}
