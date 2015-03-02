package com.example.hibernate.dao;

import com.example.hibernate.entities.Article;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.sql.SQLQueryFactory;
import com.mysema.query.sql.mysql.MySQLQueryFactory;
import org.hibernate.annotations.SQLInsert;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

import com.mysema.query.sql.dml.SQLInsertClause;

import static com.example.hibernate.entities.QArticle.article;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class ArticleDaoImpl implements ArticleDao {
    @Nonnull
    protected EntityManager entityManager;

    @Nonnull
    @Override
    public JPQLQuery query() {
        return new JPAQuery(entityManager);
    }

    @Override
    public Article findById(@Nonnull final long id) {
        return query().from(article).where(article.id.eq(id)).uniqueResult(article);
    }

    @Override
    public List<Article> findAll() {
        return query().from(article).fetchAll().list(article);
    }

    @Override
    public Article create(final Article toBeSaved) {
        entityManager.getTransaction().begin();
        entityManager.persist(toBeSaved);
        entityManager.getTransaction().commit();
        return toBeSaved;
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

    public long count() {
        return query().from(article).count();
    }

    @Nonnull
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void setEntityManager(@Nonnull EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
