package com.example.ecommerce.user.domain.payment;

import com.example.ecommerce.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String cardNumber;

    private LocalDate expirationDate;

    private String cvv;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
