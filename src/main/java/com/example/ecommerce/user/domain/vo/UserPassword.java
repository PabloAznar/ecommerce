package com.example.ecommerce.user.domain.vo;

import com.example.ecommerce.shared.domain.vo.StringValueObject;

public class UserPassword extends StringValueObject {
    public UserPassword(String value) {
        super(value);
    }

    public UserPassword() {
        super("");
    }

    @Override
    protected void ensureValidValue(String value) {

    }
}
