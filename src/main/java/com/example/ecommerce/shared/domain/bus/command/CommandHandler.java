package com.example.ecommerce.shared.domain.bus.command;

@FunctionalInterface
public interface CommandHandler <C extends Command> {
    void handle(C command);
}
