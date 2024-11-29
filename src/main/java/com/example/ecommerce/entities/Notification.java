package com.example.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

}
