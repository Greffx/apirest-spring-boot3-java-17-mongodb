package com.eduardogreff.workshopmongo.config;

import com.eduardogreff.workshopmongo.dto.AuthorDTO;
import com.eduardogreff.workshopmongo.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Let's go trip", "Going to São Paulo, Brazil, kisses", new AuthorDTO(user1));
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2018"), "Good Morning", "Woke up happy, for some reason", new AuthorDTO(user1));

        CommentDTO comment1 = new CommentDTO("Good trip bro", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(user2));
        CommentDTO comment2 = new CommentDTO("Enjoy", simpleDateFormat.parse("22/03/2018"), new AuthorDTO(user4));
        CommentDTO comment3 = new CommentDTO("Have a great day", simpleDateFormat.parse("23/03/2018"), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(user1);

    }

}
