package com.example.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"USER\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCartId;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Direction> directions;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Payment> payments;
}
