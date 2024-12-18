package com.example.ecommerce.user.application.payment.create;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.domain.payment.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPaymentCreator {

    private final UserRepository userRepository;


    public UserPaymentCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addPayment(Payment payment, final String userId) {
        User user = userRepository.findById(userId);
        user.getPayments().add(payment);
        userRepository.save(user);
    }

}
