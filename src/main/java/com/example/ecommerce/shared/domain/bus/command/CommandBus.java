package com.example.ecommerce.shared.domain.bus.command;

import org.springframework.stereotype.Component;

@FunctionalInterface
public interface CommandBus {
    void dispatch(Command command);
}
