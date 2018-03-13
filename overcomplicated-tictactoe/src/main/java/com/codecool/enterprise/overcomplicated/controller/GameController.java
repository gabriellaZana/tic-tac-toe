package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import com.codecool.enterprise.overcomplicated.services.MoveService;
import com.codecool.enterprise.overcomplicated.services.AvatarService;
import com.codecool.enterprise.overcomplicated.services.ComicsService;
import com.codecool.enterprise.overcomplicated.services.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"player", "game", "avatar_uri"})
public class GameController {
    @Autowired
    FunFactService funFactService;

    @Autowired
    ComicsService comicsService;

    @Autowired
    AvatarService avatarService;

    @Autowired
    MoveService moveService;

    @Autowired
    TictactoeGame game;


    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return game;
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() throws Exception {
        return avatarService.getAvatar();
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changePlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("game") TictactoeGame tictactoeGame, Model model) throws Exception {
        model.addAttribute("funfact", funFactService.getFunfact());
        model.addAttribute("comic_uri", comicsService.getComic());
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        System.out.println("Player moved " + move);
        moveService.moveLogic(move);
        return "redirect:/game";
    }
}
