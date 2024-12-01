package com.example.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany
    private List<Product> pendingProducts;

}
