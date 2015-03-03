package com.example.hibernate.core;

import org.apache.commons.io.IOUtils;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
public class Read {

    static byte[] readPicture(@Nonnull URL url) {
        InputStream is = null;
        byte[] imageBytes = null;
        try {
            is = url.openStream();
            imageBytes = IOUtils.toByteArray(is);
        } catch (IOException e) {
            System.err.printf("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return imageBytes;
    }

    static String getSubstringAfterChar(final char lastChar, final String word) {
        return word.substring(word.lastIndexOf(lastChar) + 1);
    }
}
