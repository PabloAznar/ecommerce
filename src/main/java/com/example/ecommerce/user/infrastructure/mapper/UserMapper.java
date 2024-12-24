package com.example.ecommerce.user.infrastructure.mapper;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "shoppingCartId", source = "shoppingCart.shoppingCartId")
    @Mapping(target = "id", expression = "java(user.id())")
    @Mapping(target = "name", expression = "java(user.name())")
    @Mapping(target = "surname", expression = "java(user.surname())")
    @Mapping(target = "email", expression = "java(user.email())")
    @Mapping(target = "phone", expression = "java(user.phone())")
    @Mapping(target = "password", expression = "java(user.password())")
    UserDto toDto(User user);

}
