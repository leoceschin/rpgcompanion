package com.rpgcompanion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rpgcompanion.dtos.RollDto;

import com.rpgcompanion.services.PlayerService;

@RestController
public class ActionController {
    @Autowired
    PlayerService playerService;

    @PutMapping("/add-damage")
    public ResponseEntity<String> addDamegeToPlayer(@RequestBody RollDto rollDto){
        String result = playerService.addDamage(rollDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/roll")
    public ResponseEntity<String> rollDice(@RequestBody RollDto rollDto){
        String result = playerService.rollDice(rollDto);
        return ResponseEntity.ok(result);

    }
}
