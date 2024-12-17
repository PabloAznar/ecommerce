package com.example.ecommerce.user.infrastructure.address;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.address.find.UserAddressFinder;
import com.example.ecommerce.user.domain.adress.dto.AddressDto;
import com.example.ecommerce.user.infrastructure.mapper.AddressMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAddressGetController {

    AddressMapper MAPPER = Mappers.getMapper( AddressMapper.class );

    private final UserAddressFinder userAddressFinder;

    public UserAddressGetController(UserAddressFinder userAddressFinder) {
        this.userAddressFinder = userAddressFinder;
    }

    @GetMapping(Constants.API_BASE_PATH + "/users/{userId}/address")
    public List<AddressDto> getUserAdress(@PathVariable("userId") final String userId) {
        return MAPPER.toDtos(userAddressFinder.findByUser(userId));
    }

}
