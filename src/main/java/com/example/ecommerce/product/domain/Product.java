package com.example.ecommerce.product.domain;

import com.example.ecommerce.entities.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
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
