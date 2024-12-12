package com.example.ecommerce.shared.infrastructure.events;

import com.example.ecommerce.shared.domain.events.AbstractEvent;
import com.example.ecommerce.shared.domain.events.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringEventBus(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<AbstractEvent> events) {
        events.forEach(this::publish);
    }

    @Override
    public void publish(AbstractEvent event) {
        publisher.publishEvent(event);
    }
}
