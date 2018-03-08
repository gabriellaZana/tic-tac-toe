package com.codecool.enterprise.overcomplicated.services;

import org.springframework.stereotype.Service;

@Service
public class FunFactService {

    private static final String FUNFACT_SERVICE_URL = "http://localhost:60001/get-funfact";

    public String getFunfact() throws Exception {
        String funfact = JSONReader.readUrl(FUNFACT_SERVICE_URL);
        return funfact;
    }

}
