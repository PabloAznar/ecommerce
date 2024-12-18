package com.example.ecommerce.user.domain.payment;

import com.example.ecommerce.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private String cvv;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
