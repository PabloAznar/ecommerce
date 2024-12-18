package com.example.ecommerce.notification.domain;

import com.example.ecommerce.user.domain.User;
import jakarta.persistence.*;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

}
