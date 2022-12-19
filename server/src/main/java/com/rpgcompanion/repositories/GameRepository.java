package com.rpgcompanion.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpgcompanion.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID>{
    
}
