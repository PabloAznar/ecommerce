package com.example.ecommerce.user.application.create;

import com.example.ecommerce.shared.domain.bus.command.Command;
import lombok.Data;

@Data
public class CreateUserCommand implements Command {
    private String id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String password;
}
