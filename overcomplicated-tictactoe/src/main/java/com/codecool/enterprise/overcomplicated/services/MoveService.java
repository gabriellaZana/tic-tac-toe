package com.codecool.enterprise.overcomplicated.services;


import com.codecool.enterprise.overcomplicated.model.AiMove;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.codecool.enterprise.overcomplicated.services.JSONReader.readUrl;

@Service
public class MoveService {

    @Autowired
    TictactoeGame game;

    private static final String AI_SERVICE_URL = "http://localhost:60004/get-ai-move";

    public String getAiMove() {
        return AI_SERVICE_URL;
    }

    public void moveLogic(int move) {
        game.setGameState(move, "X");
        int numberFromAPI = getNumberFromApi();
        if (game.getMapValue(numberFromAPI).equals("")) {
            game.setGameState(numberFromAPI, "O");
        } else {
            moveLogic(move);
        }
        System.out.println(game.getGameState().toString());
    }

    public int getNumberFromApi(){
        Gson g = new Gson();
        String json = null;
        try {
            json = readUrl(AI_SERVICE_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AiMove move = g.fromJson(json, AiMove.class);
        return move.getMove();
    }
}
