package com.example.hibernate.dao;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;

/**
 * Created by Cannibal on 22.2.2015 г..
 */
public interface QueryHandler {
    @Nonnull
    public EntityManager getEntityManager() ;

    public void setEntityManager(@Nonnull EntityManager entityManager);

    @Nonnull
    public JPQLQuery query();
}
