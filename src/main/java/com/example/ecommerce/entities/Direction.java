package com.example.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String country;

    private String city;

    private String postalCode;

}
