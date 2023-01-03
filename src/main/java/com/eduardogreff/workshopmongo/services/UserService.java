package com.eduardogreff.workshopmongo.services;

import com.eduardogreff.workshopmongo.entities.User;
import com.eduardogreff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }


}
