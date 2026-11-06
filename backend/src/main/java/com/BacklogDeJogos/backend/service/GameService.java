package com.BacklogDeJogos.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.BacklogDeJogos.backend.dto.GameDTO;
import com.BacklogDeJogos.backend.mapper.GameMapper;
import com.BacklogDeJogos.backend.model.Game;
import com.BacklogDeJogos.backend.repository.GameRepository;

@Service
@Transactional
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    

    public GameDTO create(GameDTO dto) {
        Game game = GameMapper.toEntity(dto);
        Game savedGame = gameRepository.save(game);

        return GameMapper.toDTO(savedGame);
    }


    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMapper::toDTO)
                .toList();
    }


    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return GameMapper.toDTO(findGameOrThrow(id));
    }


    public GameDTO update(Long id, GameDTO dto) {
        Game game = findGameOrThrow(id);

        game.setName(dto.getName());
        game.setDescription(dto.getDescription());
        game.setValue(dto.getValue());
        game.setQuantity(dto.getQuantity());

        return GameMapper.toDTO(gameRepository.save(game));
    }


    public void delete(Long id) {
        Game game = findGameOrThrow(id);
        gameRepository.delete(game);
    }

    private Game findGameOrThrow(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Jogo não encontrado"
                ));
    }
}