package com.example.ecommerce.product.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String title;

    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

}
