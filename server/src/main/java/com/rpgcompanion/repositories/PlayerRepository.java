package com.rpgcompanion.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpgcompanion.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
        
    @Query(
        value="SELECT P FROM Player AS P WHERE P.name = ?1 AND P.chatId = ?2"
    )
    Optional<Player> findByNameAndChatid(String name, Long chatId);
}
