package com.example.ecommerce.shared.domain.vo;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {

    private final String value;

    public Identifier(String value) {
        ensureValidUuid(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
