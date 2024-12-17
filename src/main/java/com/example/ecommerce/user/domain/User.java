package com.example.ecommerce.user.domain;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.payment.Payment;
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Payment> payments;

}
