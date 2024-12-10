package com.example.ecommerce.user.application.create;

import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.infrastructure.PostgresUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserRepository userRepository;

    public UserCreator(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }
}
