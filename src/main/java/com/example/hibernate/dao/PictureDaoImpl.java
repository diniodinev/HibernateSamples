package com.example.hibernate.dao;

import com.example.hibernate.entities.Picture;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import java.util.List;

import static com.example.hibernate.entities.QPicture.picture1;

/*
* Copyright 2013 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
 * Created by dinyo dinev on 2.3.2015 г..
*/
public class PictureDaoImpl implements PictureDao {
    @Nonnull
    protected EntityManager entityManager;

    @Override
    public Picture findById(long id) {
        return query().from(picture1).where(picture1.id.eq(id)).uniqueResult(picture1);
    }

    @Override
    public List<Picture> findAll() {
        return query().fetchAll().list(picture1);
    }

    @Override
    public JPQLQuery query() {
        return new JPAQuery(entityManager);
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

    @Override
    public Picture create(Picture toBeSaved) {
        entityManager.getTransaction().begin();
        entityManager.persist(toBeSaved);
        entityManager.getTransaction().commit();
        return toBeSaved;
    }

    @Override
    public Picture rename(Picture toBeRenamed) {
        return null;
    }

    @Override
    public Picture update(Picture toBeUpdated) {
        return null;
    }

    @Override
    public Picture delete(Picture toBeDeleted) {
        return null;
    }
}
