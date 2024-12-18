package com.example.ecommerce.user.infrastructure.address;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.address.create.UserAddressCreator;
import com.example.ecommerce.user.domain.adress.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddressPutController {

    private final UserAddressCreator userAddressCreator;

    public UserAddressPutController(UserAddressCreator userAddressCreator) {
        this.userAddressCreator = userAddressCreator;
    }

    @PutMapping(path = Constants.API_BASE_PATH + "/users/{userId}/address", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUserAddress(@PathVariable("userId") final String userId, @RequestBody final Address address) {
        userAddressCreator.create(userId, address);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
