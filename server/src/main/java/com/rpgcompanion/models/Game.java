package com.rpgcompanion.models;

import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_games")
public class Game {
    
    @Id
    private Long chatId;
    @OneToMany
    private List<Player> players;
    private GameStatus gameStatus;
    
    public Game() {
    }

    public Long getId() {
        return chatId;
    }

    public void setId(Long chatId) {
        this.chatId = chatId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    
    
}
