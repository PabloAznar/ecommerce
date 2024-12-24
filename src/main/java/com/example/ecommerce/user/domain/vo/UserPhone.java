package com.example.ecommerce.user.domain.vo;

import com.example.ecommerce.shared.domain.vo.StringValueObject;

public class UserPhone extends StringValueObject {
    public UserPhone(String value) {
        super(value);
    }

    public UserPhone() {
        super("");
    }

    @Override
    protected void ensureValidValue(String value) {

    }
}
