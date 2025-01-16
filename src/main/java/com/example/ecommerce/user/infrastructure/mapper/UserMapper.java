package com.example.ecommerce.user.infrastructure.mapper;

import com.example.ecommerce.user.application.create.CreateUserCommand;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "shoppingCartId", source = "shoppingCart.id")
    UserDto toDto(User user);

    User toEntity(CreateUserCommand userCommand);

}
