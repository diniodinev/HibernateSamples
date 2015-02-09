package com.example.hibernate.services;

import com.example.hibernate.entities.Article;

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


    @Override
    public List<Article> findAll() {
        try {
            entityManager.getTransaction().begin();
            return entityManager.createQuery("SELECT a FROM Article a").getResultList();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
