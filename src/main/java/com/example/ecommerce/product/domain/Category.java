package com.example.ecommerce.product.domain;

import lombok.Getter;

@Getter
public enum Category {

    PRUEBA("Prueba");

    private String category;

    Category(String category) {
        this.category = category;
    }

}
