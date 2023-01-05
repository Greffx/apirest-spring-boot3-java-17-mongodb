package com.eduardogreff.workshopmongo.repository;

import com.eduardogreff.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ <'title'>: { $regex: ?0, $options: 'i' } }")
    List<Post> searchByTitle(String text);


    // List<Post> findByTitleContainingIgnoreCase(String text); another way to do the same thing
}
