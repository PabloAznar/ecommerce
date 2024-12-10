package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.user.application.search.IdUserFinder;
import com.example.ecommerce.user.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${endpoints.base}")
public class UserGetController {

    private final IdUserFinder idUserFinder;

    public UserGetController(final IdUserFinder idUserFinder) {
        this.idUserFinder = idUserFinder;
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") final String id) {
        return idUserFinder.find(id);
    }
}
