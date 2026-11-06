package com.BacklogDeJogos.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Schema(description = "Product data transfer object")
public class GameDTO {

    @Schema(description = "Unique identifier of the product", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 chacacters")
    @Schema(description = "Name of the game", example = "Elden Ring")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 chacacters")
    @Schema(description = "Short description is required", example = "I liked the game, it was fun")
    private String description;

    @Positive(message = "Value must be greater than zero")
    @Schema(description = "Price of the game", example = "999.99")
    private double value;

    @PositiveOrZero(message = "Quantity must be zero or greater")
    @Schema(description = "The many games ever been finished by you", example = "50")
    private int quantity;


    public GameDTO() {
        
    }


    public GameDTO(Long id, String description, double value, int quantity, String name) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }
    

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}