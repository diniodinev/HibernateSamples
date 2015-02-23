package com.example.hibernate.dao;

import com.example.hibernate.entities.Article;
import com.example.hibernate.entities.QArticle;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class ArticleDaoImpl implements ArticleDao {
    @Nonnull
    protected EntityManager entityManager;

    private QArticle article = QArticle.article;

    @Nonnull
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void setEntityManager(@Nonnull EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Nonnull
    @Override
    public JPQLQuery query() {
        return new JPAQuery(entityManager);
    }

    @Override
    public Article findById(@Nonnull final long id) {
        QArticle article = QArticle.article;
        return query().from(article).where(article.id.eq(id)).uniqueResult(article);
    }

    @Override
    public List<Article> findAll() {
        QArticle article = QArticle.article;
        return query().from(article).fetchAll().list(article);
    }

    @Override
    public Article create(final Article toBeSaved) {
        return null;
    }

    @Override
    public Article rename(final Article toBeRenamed) {
        return null;
    }

    @Override
    public Article update(final Article toBeUpdated) {
        return null;
    }

    @Override
    public Article delete(final Article toBeDeleted) {
        return null;
    }

    @Override
    public Article save(final Article objectToSave) {
        return null;
    }

    public long count() {
        return query().from(article).count();
    }
}
