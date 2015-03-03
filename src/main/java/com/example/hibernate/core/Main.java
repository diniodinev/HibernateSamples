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
import com.example.hibernate.entities.Comment;
import com.example.hibernate.entities.Picture;
import com.example.hibernate.services.*;
import org.apache.commons.io.FilenameUtils;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        startServer();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Comment comment = new Comment();
        comment.setAuthor("Hitler");
        comment.setContent("Good comment content.");
        CommentService commentService = new CommentServiceImpl(entityManager);
        commentService.save(comment);

        ArticleService articleService = new ArticleServiceImpl(entityManager);
        List<Article> articles = articleService.findAll();

        for (Article a : articles) {
            System.out.println(a.getUrl());
        }


        Article article = new Article();
        article.setUrl("asdasdas");
        article.getComments().add(comment);
        articleService.save(article);


        System.out.println("Find by id:" + articleService.findById(1l).getUrl());
        System.out.println("Count in DB:" + articleService.count());

        //Picture test
        PictureService pictureService = new PictureServiceImpl(entityManager);


        for (int i = 98887; i > 98884; i--) {
            Picture picture = new Picture();
            try {
                String link = "http://85.14.28.164/d/images/slideshows/00000" + i + ".jpg";
                picture.setPicture(Read.readPicture(new URL(link)));
                picture.setPictureName(FilenameUtils.removeExtension(Read.getSubstringAfterChar('/', link)));
                pictureService.save(picture);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


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
