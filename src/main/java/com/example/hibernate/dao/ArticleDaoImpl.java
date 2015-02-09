package com.example.hibernate.dao;

import com.example.hibernate.entities.Article;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class ArticleDaoImpl implements ArticleDao {
    @Nonnull
    private EntityManager entityManager;

    @Override
    public Article findById(long id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return entityManager.createQuery("select * from Article").getResultList();
    }

    @Override
    public Article create(Article toBeSaved) {
        return null;
    }

    @Override
    public Article rename(Article toBeRenamed) {
        return null;
    }

    @Override
    public Article update(Article toBeUpdated) {
        return null;
    }

    @Override
    public Article delete(Article toBeDeleted) {
        return null;
    }

    @Nonnull
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(@Nonnull EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
