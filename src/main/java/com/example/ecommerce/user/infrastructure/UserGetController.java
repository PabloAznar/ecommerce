package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.user.application.find.IdUserFinder;
import com.example.ecommerce.user.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserGetController {

    private final IdUserFinder userFinder;

    public UserGetController(final IdUserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @GetMapping(Constants.API_BASE_PATH + "/users/{id}")
    public User getUser(@PathVariable("id") final String id) {
        return userFinder.find(id);
    }
}
