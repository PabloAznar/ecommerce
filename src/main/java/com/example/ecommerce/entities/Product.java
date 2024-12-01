package com.example.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

}
