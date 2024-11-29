package com.example.ecommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String cardNumber;

    private LocalDate expirationDate;

    private String cvv;

}
