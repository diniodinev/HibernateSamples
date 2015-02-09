package com.example.hibernate.entities;

import javax.annotation.CheckForNull;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.persistence.*;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
@Entity
public class Article {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nonnull
    private long id;

    @Column(name = "name", nullable = true, length = 512)
    @CheckForNull
    private String url;

    public Article() {
    }

    @Nonnull
    public long getId() {
        return id;
    }

    public void setId(@Nonnull final long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
