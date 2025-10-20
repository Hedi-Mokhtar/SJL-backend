package com.sjl.application.service;

import com.sjl.domain.model.player.Player;
import com.sjl.domain.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PlayerApplicationService {

    private final PlayerRepository playerRepository;

    public PlayerApplicationService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAllPlayers();
    }

    public Player getById(UUID id) {
        return playerRepository.findPlayerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));
    }

    @Transactional
    public Player create(Player player) {
        playerRepository.save(player);
        return player;
    }

    @Transactional
    public void delete(UUID id) {
        playerRepository.delete(id);
    }
}
