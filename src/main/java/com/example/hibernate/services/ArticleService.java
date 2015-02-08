package com.example.hibernate.services;

import com.example.hibernate.entities.Article;

import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class ArticleService extends AbstractService<Article> {

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
