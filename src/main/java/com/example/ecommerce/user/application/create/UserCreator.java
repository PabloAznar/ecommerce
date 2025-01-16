package com.example.ecommerce.user.application.create;

import com.example.ecommerce.shared.domain.bus.command.CommandHandler;
import com.example.ecommerce.shared.domain.events.EventBus;
import com.example.ecommerce.shared.user.domain.UserCreatedEvent;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.infrastructure.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class UserCreator implements CommandHandler<CreateUserCommand> {

    private final UserRepository userRepository;

    private final EventBus eventBus;

    UserMapper MAPPER = Mappers.getMapper( UserMapper.class );

    public UserCreator(final UserRepository userRepository, final EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void handle(CreateUserCommand createUserCommand) {
        User user = MAPPER.toEntity(createUserCommand);
        this.userRepository.save(user);
        eventBus.publish(new UserCreatedEvent(user));
    }
}
