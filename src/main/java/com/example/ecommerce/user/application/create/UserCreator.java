package com.example.ecommerce.user.application.create;

import com.example.ecommerce.shared.events.domain.EventBus;
import com.example.ecommerce.shared.user.domain.UserCreatedEvent;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserRepository userRepository;

    private final EventBus eventBus;

    public UserCreator(final UserRepository userRepository, final EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void create(User user) {
        this.userRepository.save(user);
        eventBus.publish(new UserCreatedEvent(user));
    }
}
