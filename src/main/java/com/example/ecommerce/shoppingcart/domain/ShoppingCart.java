package com.example.ecommerce.shoppingcart.domain;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "shopping_cart_product",
            joinColumns = @JoinColumn(name = "shopping_cart_id"), // Correct spelling here
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> pendingProducts;


}
