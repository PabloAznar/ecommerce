package com.example.ecommerce.shared.user.domain;

import com.example.ecommerce.shared.events.domain.AbstractEvent;
import com.example.ecommerce.user.domain.User;

public class UserCreatedEvent extends AbstractEvent {

    private User user;

    public UserCreatedEvent(final User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
