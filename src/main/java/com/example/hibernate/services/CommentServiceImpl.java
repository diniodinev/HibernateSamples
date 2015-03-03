package com.example.hibernate.services;

import com.example.hibernate.dao.ArticleDao;
import com.example.hibernate.dao.ArticleDaoImpl;
import com.example.hibernate.dao.CommentDao;
import com.example.hibernate.dao.CommentDaoImpl;
import com.example.hibernate.entities.Comment;

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
public class CommentServiceImpl extends CommentService {

    private CommentDao dao;

    public CommentServiceImpl(final EntityManager entityManager) {
        dao = new CommentDaoImpl();
        dao.setEntityManager(entityManager);
    }

    @Override
    public Comment findById(@Nonnull long id) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Comment comment) {
        dao.create(comment);
    }
}
