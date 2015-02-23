package com.example.hibernate.dao;

import com.example.hibernate.entities.Comment;
import com.example.hibernate.entities.QComment;
import com.mysema.query.jpa.JPQLQuery;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public class CommentDaoImpl implements CommentDao {

    protected EntityManager entityManager;

    @Nonnull
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void setEntityManager(@Nonnull EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public JPQLQuery query() {
        return null;
    }

    @Override
    public Comment findById(long id) {
        QComment comment = QComment.comment;
        return query().from(comment).where(comment.id.eq(id)).uniqueResult(comment);
    }

    @Override
    public List<Comment> findAll() {
        QComment comment = QComment.comment;
        return query().from(comment).fetchAll().list(comment);
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

    @Override
    public Comment save(Comment objectTOSave) {
        return null;
    }

}
