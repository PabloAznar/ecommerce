package com.example.ecommerce.user.application.address.find;

import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.domain.adress.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressFinder {

    private final UserRepository userRepository;

    public UserAddressFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Address> findByUser(final String userId) {
        return userRepository.findAddressesByUser(userId);
    }

}
