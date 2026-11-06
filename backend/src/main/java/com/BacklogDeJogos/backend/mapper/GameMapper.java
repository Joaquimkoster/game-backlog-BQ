package com.BacklogDeJogos.backend.mapper;

import com.BacklogDeJogos.backend.dto.GameDTO;
import com.BacklogDeJogos.backend.model.Game;

public class GameMapper {

    private GameMapper() {}

    public static GameDTO toDTO(Game game){
        return new GameDTO(
            game.getId(),
            game.getDescription(),
            game.getValue(),
            game.getQuantity(),
            game.getName()
    );

    }
    

    public static Game toEntity(GameDTO gameDTO){
        return new Game(
            gameDTO.getName(),
            gameDTO.getDescription(),
            gameDTO.getValue(),
            gameDTO.getQuantity()
        );
    }

}