package com.example.hibernate.services;
/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
  * Created by dinyo.dinev on 2015.
 */


import javax.annotation.Nonnull;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class AbstractService<E> {
    public abstract E findById(@Nonnull final long id);

    public abstract List<E> findAll();

    public abstract long count();

    public abstract void save(E article);
}