package com.example.hibernate.entities;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Cannibal on 8.2.2015 г..
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Nonnull
    private long id;

    @CheckForNull
    @Column(name = "author", nullable = true, length = 20)
    private String author;

    @CheckForNull
    @Column(name = "content", nullable = true, length = 512)
    private String content;

    public Comment() {
    }

    @Nonnull
    public long getId() {
        return id;
    }

    public void setId(@Nonnull final long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }
}
