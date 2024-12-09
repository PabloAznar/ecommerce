package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.Criteria;
import com.example.ecommerce.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${endpoints.base}")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") final String id) {
        return userService.findById(id);
    }

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("user/criteria")
    public List<User> findByCriteria(@RequestBody Criteria criteria) {
        return userService.findByCriteria(criteria);
    }

}
