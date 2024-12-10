package com.example.ecommerce.user.application.search;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class IdUserFinder {

    private final UserRepository userRepository;

    public IdUserFinder(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User find(final String id) {
        return userRepository.findById(id);
    }

}
