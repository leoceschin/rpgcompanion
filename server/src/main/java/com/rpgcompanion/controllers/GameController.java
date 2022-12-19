package com.rpgcompanion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rpgcompanion.dtos.PlayerDto;
import com.rpgcompanion.models.Game;
import com.rpgcompanion.models.Player;
import com.rpgcompanion.services.GameService;
import com.rpgcompanion.services.PlayerService;

@RestController
public class GameController {
    
    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;
    
    @PostMapping("/game-init/{chatId}")
    public ResponseEntity<Game> startGame(@PathVariable(value = "chatId") Long id){
        return ResponseEntity.ok(gameService.createGame(id));
    }

    @PostMapping("/add-player")
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerDto playerDto){
        return ResponseEntity.ok(playerService.createPlayer(playerDto));
    }

}
