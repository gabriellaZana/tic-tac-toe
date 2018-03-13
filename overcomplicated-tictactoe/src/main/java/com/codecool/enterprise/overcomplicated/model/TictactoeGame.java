package com.codecool.enterprise.overcomplicated.model;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TictactoeGame {

    private Map<Integer, String> gameState;

    public TictactoeGame() {
        gameState = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            setGameState(i, "");
        }
    }

    public Map<Integer, String> getGameState() {
        return gameState;
    }

    public String getMapValue(int key) {
        return gameState.get(key);
    }

    public void setGameState(int key, String value) {
        gameState.put(key, value);
    }

    @Override
    public String toString() {
        return "TictactoeGame{" +
                "gameState=" + gameState +
                '}';
    }

}
