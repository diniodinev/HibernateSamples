package com.example.hibernate.dao;

import com.example.hibernate.entities.Article;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public interface ArticleDao extends ExtendedDao<Article>,QueryHandler {
    public long count();
}
