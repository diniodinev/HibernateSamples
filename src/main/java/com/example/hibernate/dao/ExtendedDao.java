package com.example.hibernate.dao;

import com.mysema.query.jpa.JPQLQuery;

import java.util.List;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public interface ExtendedDao<E> extends SampleDao<E> {

    public E findById(long id);

    public List<E> findAll();

    public JPQLQuery query();
}

