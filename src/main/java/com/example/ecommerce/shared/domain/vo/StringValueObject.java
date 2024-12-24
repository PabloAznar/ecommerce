package com.example.ecommerce.shared.domain.vo;

import java.util.Objects;

public abstract class StringValueObject {

    private String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    protected abstract void ensureValidValue(String value);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public String value() {
        return this.value;
    }

}
