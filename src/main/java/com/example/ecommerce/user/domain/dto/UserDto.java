package com.example.ecommerce.user.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String password;

    private String shoppingCartId;

}
