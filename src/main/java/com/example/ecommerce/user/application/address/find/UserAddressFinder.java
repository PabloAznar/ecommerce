package com.example.ecommerce.user.application.address.find;

import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.adress.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressFinder {

    private final AddressRepository addressRepository;

    public UserAddressFinder(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findByUser(final String userId) {
        return this.addressRepository.findByUserId(userId);
    }

}
