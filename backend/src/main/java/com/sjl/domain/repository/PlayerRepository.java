package com.sjl.domain.repository;

import com.sjl.domain.model.player.Player;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository {
    List<Player> findAllPlayers();
    Optional<Player> findPlayerById(UUID id);
    void save(Player player);
    void delete(UUID id);
}
