package com.example.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(schema = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany
    private List<Product> pendingProducts;

}
