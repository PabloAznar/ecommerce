package com.example.ecommerce.user.domain.vo;

import com.example.ecommerce.shared.domain.vo.StringValueObject;

public class UserEmail extends StringValueObject {

    public UserEmail(String value) {
        super(value);
    }

    public UserEmail() {
        super("");
    }

    @Override
    protected void ensureValidValue(String value) {

    }
}
