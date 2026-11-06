package com.BacklogDeJogos.backend.controller;

import java.net.URI;
import java.util.List;

import com.BacklogDeJogos.backend.dto.GameDTO;
import com.BacklogDeJogos.backend.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    

    @PostMapping
    public ResponseEntity<GameDTO> create(
            @Valid @RequestBody GameDTO dto) {

        GameDTO createdGame = gameService.create(dto);

        URI location = URI.create("/games/" + createdGame.getId());

        return ResponseEntity.created(location).body(createdGame);
    }


    @GetMapping
    public List<GameDTO> findAll() {
        return gameService.findAll();
    }


    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }


    @PutMapping("/{id}")
    public GameDTO update(
            @PathVariable("id") Long id,
            @Valid @RequestBody GameDTO dto) {

        return gameService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Long id) {

        gameService.delete(id);

        return ResponseEntity.noContent().build();
    }
}