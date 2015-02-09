package com.example.hibernate.core;

/*
* Copyright 2013 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
 * Created by dinyo dinev on 9.2.2015 г..
*/

import com.example.hibernate.entities.Article;
import com.example.hibernate.services.ArticleServiceImpl;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        ArticleServiceImpl articleService = new ArticleServiceImpl();
        articleService.setEntityManager(entityManager);
        List<Article> articles =articleService.findAll();

        for(Article a:articles){
            System.out.println(a);
        }

        startServer();

    }

    public static void startServer() {
        //TODO For testing purposes only, to be deleted
        Server server = null;
        try {
            server = Server.createTcpServer().start();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info("Server started and connection is open.");
        logger.info("URL: jdbc:h2:" + server.getURL() + "/mem:test");
    }
}
