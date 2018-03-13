package com.codecool.enterprise.ai.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AiController {

    @RequestMapping(value = "/get-ai-move", method = RequestMethod.GET)
    public String getAiMove() {
        String move;
        Random random = new Random();
        int low = 0;
        int high = 9;
        move = String.valueOf(random.nextInt(high-low) + low);

        return move;
    }

}
