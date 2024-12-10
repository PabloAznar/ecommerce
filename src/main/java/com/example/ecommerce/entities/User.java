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
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Direction> directions;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Payment> payments;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getShoppingCart() {
       return shoppingCart;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
