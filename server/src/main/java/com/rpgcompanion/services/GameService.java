package com.rpgcompanion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpgcompanion.models.Game;
import com.rpgcompanion.models.GameStatus;
import com.rpgcompanion.models.Player;
import com.rpgcompanion.repositories.GameRepository;
import com.rpgcompanion.repositories.PlayerRepository;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired 
    PlayerRepository playerRepository;

    public Game createGame(Long chatId){
        Optional<Game> activeGame = gameRepository.findById(chatId);
        if(activeGame.isPresent()){
            throw new RuntimeException("Já existe um game nessa sala!");
        }else{
            Game game = new Game();
            game.setChatId(chatId);
            game.setGameStatus(GameStatus.ACTIVE);
            gameRepository.save(game);
            return game;
        }
    }

    public Game getGameById(Long chatId){
        Optional<Game> activeGame = gameRepository.findById(chatId);
        Game game = new Game();
        game = activeGame.get(); 
        return game;
    }

    public List<Player> listAllPlayersFromGame(Long chatId){
        Game game = new Game();
        Optional<Game> gameActive = gameRepository.findById(chatId);
        List<Player> playerList = new ArrayList<Player>();
        if(gameActive.isPresent()){
            game = gameActive.get();
            playerList = game.getPlayers();
        }else{
            throw new RuntimeException();
        }
        return playerList;
    }

    public void addPlayer(Player player, Game game){
        List<Player> listPlayer = game.getPlayers();
        if(listPlayer == null) {listPlayer = new ArrayList<Player>();}
        listPlayer.add(player);
        game.setPlayers(listPlayer);
        gameRepository.save(game);
        player.setActiveGame(game);
        playerRepository.save(player);
    }
}
