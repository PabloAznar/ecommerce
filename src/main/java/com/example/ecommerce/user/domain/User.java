package com.example.ecommerce.user.domain;

import com.example.ecommerce.entities.Direction;
import com.example.ecommerce.entities.Payment;
import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Direction> directions;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Payment> payments;

}
