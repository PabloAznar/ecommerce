package com.example.ecommerce.shared.domain;

import com.example.ecommerce.shared.exceptions.ECommerceException;
import com.example.ecommerce.shared.exceptions.ExceptionType;

public enum OperationFilter {
    EQUALS("="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    CONTAINS("contains");

    private String operation;

    OperationFilter(String operation) {
        this.operation = operation;
    }

    public static OperationFilter fromValue(String value) {
        return switch (value) {
            case "=" ->  OperationFilter.EQUALS;
            case "!=" ->  OperationFilter.NOT_EQUALS;
            case ">" ->  OperationFilter.GREATER_THAN;
            case "<" ->  OperationFilter.LESS_THAN;
            case "contains" ->  OperationFilter.CONTAINS;
            default -> throw new ECommerceException(ExceptionType.OPERATION_NOT_SUPPORTED);
        };
    }

    public String getOperation() {
        return operation;
    }

}
