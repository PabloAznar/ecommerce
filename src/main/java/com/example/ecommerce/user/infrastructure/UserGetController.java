package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.find.IdUserFinder;
import com.example.ecommerce.user.domain.dto.UserDto;
import com.example.ecommerce.user.infrastructure.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetController {

    private final IdUserFinder userFinder;

    UserMapper MAPPER = Mappers.getMapper( UserMapper.class );

    public UserGetController(final IdUserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @GetMapping(Constants.API_BASE_PATH + "/users/{id}")
    public UserDto getUser(@PathVariable("id") final String id) {
        return MAPPER.toDto(userFinder.find(id));
    }
}
