package com.example.ecommerce.shoppingcart.domain;

import com.example.ecommerce.entities.Product;
import com.example.ecommerce.user.domain.User;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(mappedBy = "shoppingCart")
    private User user;

    @ManyToMany
    private List<Product> pendingProducts;

}
