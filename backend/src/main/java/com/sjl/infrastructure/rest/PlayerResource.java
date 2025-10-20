package com.sjl.infrastructure.rest;

import com.sjl.application.service.PlayerApplicationService;
import com.sjl.domain.model.player.Player;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final PlayerApplicationService playerService;

    public PlayerResource(PlayerApplicationService playerService) {
        this.playerService = playerService;
    }

    @GET
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GET
    @Path("/{id}")
    public Player getPlayerById(@PathParam("id") UUID id) {
        return playerService.getById(id);
    }

    @POST
    public Player createPlayer(Player player) {
        return playerService.create(player);
    }

    @DELETE
    @Path("/{id}")
    public void deletePlayer(@PathParam("id") UUID id) {
        playerService.delete(id);
    }
}
