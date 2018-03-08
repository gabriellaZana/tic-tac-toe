package com.codecool.enterprise.ai.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    @RequestMapping(value = "/get-ai-move", method = RequestMethod.GET)
    public String getAiMove() {
        return "";
    }

}
