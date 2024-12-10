package com.example.ecommerce.user.application.search;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllUserFinder {

    private final UserRepository userRepository;

    public AllUserFinder(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> search() {
        return userRepository.findAll();
    }
}
