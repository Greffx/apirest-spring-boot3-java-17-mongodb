package com.eduardogreff.workshopmongo.controllers;

import com.eduardogreff.workshopmongo.dto.UserDTO;
import com.eduardogreff.workshopmongo.entities.User;
import com.eduardogreff.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> userDTOS = service.findAll().stream().map(user -> new UserDTO(user)).toList();
        return ResponseEntity.ok().body(userDTOS);
    }
}
