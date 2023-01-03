package com.eduardogreff.workshopmongo.controllers;

import com.eduardogreff.workshopmongo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User(1, "maria", "maria@gmail.com");
        User user1 = new User(2, "jonas", "jonas@gmail.com");
        List<User> users = Arrays.asList(user, user1);
        return ResponseEntity.ok().body(users);
    }
}
