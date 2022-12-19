package com.rpgcompanion.models;

import java.util.Random;

public final class Dice {
    
    public static int roll(int quantity, int sides){
        Random random = new Random();
        int result;
        result = (random.nextInt(sides) + 1) * quantity;      
        return result;
    }
}
