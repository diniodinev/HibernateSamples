package com.example.hibernate.dao;

import com.example.hibernate.entities.Comment;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class CommentDaoImpl implements CommentDao {

    @Nonnull
    private EntityManager entityManager;

    @Override
    public Comment findById(long id) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("select * from Article").getResultList();
    }

    @Override
    public Comment create(Comment toBeSaved) {
        return null;
    }

    @Override
    public Comment rename(Comment toBeRenamed) {
        return null;
    }

    @Override
    public Comment delete(Comment toBeDeleted) {
        return null;
    }

    @Override
    public Comment update(Comment toBeUpdated) {
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
