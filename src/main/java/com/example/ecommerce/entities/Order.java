package com.example.ecommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime creationDate;

    private LocalDate estimatedArraival;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
