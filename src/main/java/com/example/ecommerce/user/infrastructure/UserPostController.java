package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.user.application.create.UserCreator;
import com.example.ecommerce.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${endpoints.base}")
public class UserPostController {

    private final UserCreator userCreator;

    public UserPostController(final UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        userCreator.create(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @PostMapping("user/criteria")
//    public List<User> findByCriteria(@RequestBody Criteria criteria) {
//        return userService.findByCriteria(criteria);
//    }

}
