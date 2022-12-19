package com.rpgcompanion.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpgcompanion.dtos.PlayerDto;
import com.rpgcompanion.dtos.RollDto;
import com.rpgcompanion.models.Dice;
import com.rpgcompanion.models.Game;
import com.rpgcompanion.models.Player;
import com.rpgcompanion.models.PlayerStatus;
import com.rpgcompanion.repositories.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameService gameService;

    public Player createPlayer (PlayerDto playerDto){
        Optional<Player> optionalPlayer = playerRepository.findByNameAndChatid(playerDto.getName(), playerDto.getChatId());
        if(optionalPlayer.isPresent()){
            throw new RuntimeException("Já existe um personagem com esse nome na partida");
        }else{
            Player player = new Player();
            Game game = gameService.getGameById(playerDto.getChatId());
            player.setId(playerDto.getId());
            player.setName(playerDto.getName());
            player.setChatId(playerDto.getChatId());
            player.setLifePoints(playerDto.getLifePoints());
            player.setStatus(PlayerStatus.ALIVE);
            playerRepository.save(player);
            gameService.addPlayer(player, game);
            return player;
        }
    }

    public Player getPlayer(String name, long chatId){
        Player player = playerRepository.findByNameAndChatid(name, chatId).get();
        return player;
    }

    public String rollDice (RollDto rollDto){
        int result = Dice.roll(rollDto.getQuantity(), rollDto.getSides());
        result = result + rollDto.getAttributes();
        return "O resultado foi "+ result + "!";
    }

    public String addDamage (RollDto rollDto){
        Player player = getPlayer(rollDto.getName(), rollDto.getChatId());
        int lifePoints = player.getLifePoints();
        int damage =  Dice.roll(rollDto.getQuantity(), rollDto.getSides());
        player.setLifePoints(lifePoints - damage);
        if(player.getLifePoints() <= 0){
            player.setStatus(PlayerStatus.DEAD);
            playerRepository.save(player);
            return (player.getName() + " está morto! Que dó!");
        }else{
            playerRepository.save(player);
            return (player.getName() + " recebeu "+ damage + " de dano e ficou com "+ player.getLifePoints()+" de vida!");
        }

    }


    
}
