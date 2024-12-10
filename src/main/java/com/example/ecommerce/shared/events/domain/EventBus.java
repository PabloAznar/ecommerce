package com.example.ecommerce.shared.events.domain;

import java.util.List;

public interface EventBus {

    void publish(List<AbstractEvent> events);

    void publish(AbstractEvent event);
}
