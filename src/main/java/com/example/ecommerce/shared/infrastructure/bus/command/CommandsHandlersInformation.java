package com.example.ecommerce.shared.infrastructure.bus.command;

import com.example.ecommerce.shared.domain.bus.command.Command;
import com.example.ecommerce.shared.domain.bus.command.CommandBus;
import com.example.ecommerce.shared.domain.bus.command.CommandHandler;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import org.aspectj.util.Reflection;
import org.reflections.Reflections;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.*;

@Component
public class CommandsHandlersInformation {
    private Map<Class<? extends Command>, Class<? extends CommandHandler>> handlersMap;

    public CommandsHandlersInformation() {
        Reflections reflections = new Reflections("com.example.ecommerce");
        Set<Class<? extends CommandHandler>> commandHandlers = reflections.getSubTypesOf(CommandHandler.class);

        indexeCommandHandlers(commandHandlers);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> command) {
        Class<? extends CommandHandler> commandHandler = handlersMap.get(command);

        if(Objects.isNull(commandHandler)) {
            throw new ECommerceException(HttpStatus.NOT_FOUND, String.format("No command handler implementation found for command %s", command.getSimpleName()));
        }

        return commandHandler;
    }

    private Map<Class<? extends Command>, Class<? extends CommandHandler>> indexeCommandHandlers(Set<Class<? extends  CommandHandler>> commandHandlers) {
        handlersMap = new HashMap<>();

        commandHandlers.forEach(commandHandler -> {
            ParameterizedType parameterizedType = (ParameterizedType) commandHandler.getGenericInterfaces()[0];
            Class<? extends Command> command = (Class<? extends Command>) parameterizedType.getActualTypeArguments()[0];
            handlersMap.put(command, commandHandler);
        });

        return handlersMap;
    }
}
