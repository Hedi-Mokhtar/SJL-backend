package com.sjl.infrastructure.persistence;

import com.sjl.domain.model.player.Player;
import com.sjl.domain.repository.PlayerRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PlayerPanacheRepository implements PlayerRepository, PanacheRepositoryBase<PlayerEntity, UUID> {

    private static Player toDomain(PlayerEntity entity) {
        return new Player(
                entity.id,
                entity.firstName,
                entity.lastName,
                entity.email,
                entity.phoneNumber,
                entity.licenseNumber,
                entity.level,
                entity.referee,
                entity.manager
        );
    }

    private static PlayerEntity toEntity(Player player) {
        PlayerEntity e = new PlayerEntity();
        e.id = player.id();
        e.firstName = player.firstName();
        e.lastName = player.lastName();
        e.email = player.email();
        e.phoneNumber = player.phoneNumber();
        e.licenseNumber = player.licenseNumber();
        e.level = player.level();
        e.referee = player.referee();
        e.manager = player.manager();
        return e;
    }

    @Override
    public List<Player> findAllPlayers() {
        return listAll().stream().map(PlayerPanacheRepository::toDomain).toList();
    }

    @Override
    public Optional<Player> findPlayerById(UUID id) {
        return find("id", id).firstResultOptional().map(PlayerPanacheRepository::toDomain);
    }

    @Override
    @Transactional
    public void save(Player player) {
        persist(toEntity(player));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        delete("id", id);
    }
}
