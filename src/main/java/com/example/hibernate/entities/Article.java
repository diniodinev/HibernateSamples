package com.example.hibernate.entities;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.annotation.CheckForNull;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @ElementCollection
    @JoinTable(name = "ARTICLE_COMMENT",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ARTICLE_COMMENT_ID"), generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<Comment> comments = new ArrayList<Comment>();

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

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
