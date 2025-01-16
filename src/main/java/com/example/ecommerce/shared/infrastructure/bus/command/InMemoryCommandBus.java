package com.example.ecommerce.shared.infrastructure.bus.command;

import com.example.ecommerce.shared.domain.bus.command.Command;
import com.example.ecommerce.shared.domain.bus.command.CommandBus;
import com.example.ecommerce.shared.domain.bus.command.CommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCommandBus implements CommandBus {

    private final CommandsHandlersInformation commandsHandlersInformation;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandsHandlersInformation commandsHandlersInformation, ApplicationContext applicationContext) {
        this.commandsHandlersInformation = commandsHandlersInformation;
        this.context = applicationContext;
    }

    @Override
    public void dispatch(Command command) {
        Class<? extends CommandHandler> commandHandler = commandsHandlersInformation.search(command.getClass());
        context.getBean(commandHandler)
                .handle(command);
    }
}
