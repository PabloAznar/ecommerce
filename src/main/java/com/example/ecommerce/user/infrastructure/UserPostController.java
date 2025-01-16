package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.shared.domain.bus.command.CommandBus;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.user.application.create.CreateUserCommand;
import com.example.ecommerce.user.application.create.UserCreator;
import com.example.ecommerce.user.application.find.CriteriaUserFinder;
import com.example.ecommerce.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPostController {

    private final CommandBus commandBus;

    private final CriteriaUserFinder userFinder;

    public UserPostController(final CommandBus commandBus, final CriteriaUserFinder userFinder) {
        this.commandBus = commandBus;
        this.userFinder = userFinder;
    }

    @PostMapping(path = Constants.API_BASE_PATH + "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody CreateUserCommand command) {
        commandBus.dispatch(command);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(Constants.API_BASE_PATH + "/users/criteria")
    public List<User> findByCriteria(@RequestBody Criteria criteria) {
        return userFinder.find(criteria);
    }

}
