package com.example.hibernate.services;

import com.example.hibernate.dao.PictureDao;
import com.example.hibernate.dao.PictureDaoImpl;
import com.example.hibernate.entities.Picture;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
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
 * Created by dinyo dinev on 2.3.2015 г..
*/
public class PictureServiceImpl extends PictureService {
    private PictureDao pictureDao;

    public PictureServiceImpl(final EntityManager entityManager) {
        pictureDao = new PictureDaoImpl();
        pictureDao.setEntityManager(entityManager);
    }

    @Override
    public Picture findById(@Nonnull long id) {
        return null;
    }

    @Override
    public List<Picture> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(Picture picture) {
        pictureDao.create(picture);
    }
}
