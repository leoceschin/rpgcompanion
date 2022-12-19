package com.rpgcompanion.dtos;

import java.io.Serializable;

public class PlayerDto implements Serializable{
    private Long id;
    private String name;
    private Long chatId;
    private int lifePoints;
    public PlayerDto() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getChatId() {
        return chatId;
    }
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    
}
