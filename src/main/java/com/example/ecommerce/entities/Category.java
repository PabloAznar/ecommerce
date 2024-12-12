package com.example.ecommerce.entities;

import lombok.Getter;

@Getter
public enum Category {

    PRUEBA("Prueba");

    private String category;

    Category(String category) {
        this.category = category;
    }

}
