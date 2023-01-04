package com.eduardogreff.workshopmongo.entities;

import com.eduardogreff.workshopmongo.dto.AuthorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private  String body;
    private AuthorDTO author;

    public Post() {
    }

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.author = author;
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Post post = (Post) other;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}