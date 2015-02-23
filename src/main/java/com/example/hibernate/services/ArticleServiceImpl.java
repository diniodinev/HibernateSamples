package com.example.hibernate.services;

import com.example.hibernate.dao.ArticleDao;
import com.example.hibernate.dao.ArticleDaoImpl;
import com.example.hibernate.entities.Article;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/*
* Copyright 2013 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
 * Created by dinyo dinev on 9.2.2015 г..
*/
public class ArticleServiceImpl extends ArticleService {

    @Nonnull
    private ArticleDao dao;

    public ArticleServiceImpl(final EntityManager entityManager) {
        dao = new ArticleDaoImpl();
        dao.setEntityManager(entityManager);
    }

    @Override
    public Article findById(final long id) {
        return dao.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return dao.findAll();
    }

    @Override
    public long count() {
        return dao.count();
    }
}