package com.example.ecommerce.user.application.address.create;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.domain.adress.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAddressCreator {

    private final UserRepository userRepository;


    public UserAddressCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void create(String userId, final Address address) {
        User user = userRepository.findById(userId);
        user.getAddresses().add(address);
        userRepository.save(user);
    }
}


