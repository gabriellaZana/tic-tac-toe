package com.codecool.enterprise.overcomplicated.services;

import org.springframework.stereotype.Service;

@Service
public class ComicsService {

    private static final String COMICS_SERVICE_URL = "http://0.0.0.0:60002/get-comic";

    public String getComic() throws Exception {
        String comic = JSONReader.readUrl(COMICS_SERVICE_URL);
        return comic;
    }

}
