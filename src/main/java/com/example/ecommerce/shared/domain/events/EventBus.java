package com.example.ecommerce.shared.domain.events;

import java.util.List;

public interface EventBus {

    void publish(List<AbstractEvent> events);

    void publish(AbstractEvent event);
}
