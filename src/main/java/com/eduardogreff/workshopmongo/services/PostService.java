package com.eduardogreff.workshopmongo.services;

import com.eduardogreff.workshopmongo.entities.Post;
import com.eduardogreff.workshopmongo.repository.PostRepository;
import com.eduardogreff.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }
}