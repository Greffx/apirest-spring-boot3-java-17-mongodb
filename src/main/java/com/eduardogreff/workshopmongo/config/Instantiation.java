package com.eduardogreff.workshopmongo.config;

import com.eduardogreff.workshopmongo.entities.User;
import com.eduardogreff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void methodToCreateSomeDataToTest() {

        userRepository.deleteAll();

        User user1 = new User(null, "Eduardo", "eduardo@gmail.com");
        User user2 = new User(null, "Pedro", "pedro@gmail.com");
        User user3 = new User(null, "Bruna", "bruna@gmail.com");
        User user4 = new User(null, "João", "joao@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

    }

}
