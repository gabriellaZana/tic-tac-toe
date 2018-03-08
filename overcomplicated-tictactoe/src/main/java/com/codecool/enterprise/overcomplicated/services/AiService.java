package com.codecool.enterprise.overcomplicated.services;


import org.springframework.stereotype.Service;

@Service
public class AiService {

    private static final String AI_SERVICE_URL = "http://localhost:60004/get-ai-move";

    public String getAiMove() {
        return AI_SERVICE_URL;
    }

}
