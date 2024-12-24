package com.example.ecommerce.user.domain.vo;

import com.example.ecommerce.shared.domain.vo.StringValueObject;

public class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
        super("");
    }

    @Override
    protected void ensureValidValue(String value) {

    }
}
