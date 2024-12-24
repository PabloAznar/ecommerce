package com.example.ecommerce.user.domain.vo;

import com.example.ecommerce.shared.domain.vo.StringValueObject;

public class UserSurname extends StringValueObject {
    public UserSurname(String value) {
        super(value);
    }

    public UserSurname() {
        super("");
    }

    @Override
    protected void ensureValidValue(String value) {

    }
}
