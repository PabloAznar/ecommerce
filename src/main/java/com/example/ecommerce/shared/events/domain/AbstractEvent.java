package com.example.ecommerce.shared.events.domain;

import java.util.UUID;

public abstract class AbstractEvent {

    protected String eventId;

    public AbstractEvent() {
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId() {
        return this.eventId;
    }

}
