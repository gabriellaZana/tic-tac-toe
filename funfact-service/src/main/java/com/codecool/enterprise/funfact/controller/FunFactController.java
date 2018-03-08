package com.codecool.enterprise.funfact.controller;

import com.codecool.enterprise.funfact.model.FunFact;
import com.codecool.enterprise.funfact.model.JsonReader;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunFactController {

    @RequestMapping(value = "/get-funfact", method = RequestMethod.GET)
    public String getFunFact() throws Exception {
        String json = JsonReader.readUrl("https://api.chucknorris.io/jokes/random");
        Gson gson = new Gson();
        FunFact funFact = gson.fromJson(json, FunFact.class);
        String funfact = funFact.getValue();
        return funfact;
    }

}
