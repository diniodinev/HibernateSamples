package com.example.hibernate.services;

import com.example.hibernate.entities.Article;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public abstract class ArticleService extends AbstractService<Article> {

    public abstract Article findById(@Nonnull final long id);

    public abstract List<Article> findAll();

    public abstract long count();
}
