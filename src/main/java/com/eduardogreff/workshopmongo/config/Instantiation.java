package com.eduardogreff.workshopmongo.config;

import com.eduardogreff.workshopmongo.entities.Post;
import com.eduardogreff.workshopmongo.entities.User;
import com.eduardogreff.workshopmongo.repository.PostRepository;
import com.eduardogreff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Bean
    public void methodToCreateSomeDataToTest() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Eduardo", "eduardo@gmail.com");
        User user2 = new User(null, "Pedro", "pedro@gmail.com");
        User user3 = new User(null, "Bruna", "bruna@gmail.com");
        User user4 = new User(null, "João", "joao@gmail.com");

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Let's go trip", "Going to São Paulo, Brazil, kisses", user1);
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2018"), "Good Morning", "Woke up happy, for some reason", user1);

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }

}
