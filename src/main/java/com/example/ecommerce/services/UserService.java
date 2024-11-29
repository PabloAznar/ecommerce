package com.example.ecommerce.services;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(final String userId) {
        return this.userRepository.findById(userId);
    }
}
