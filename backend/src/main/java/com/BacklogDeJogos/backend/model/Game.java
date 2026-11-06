package com.BacklogDeJogos.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Game")

public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name; 
	
	@Column(nullable = false, length = 100)
	private String description;
	
	@Column(nullable = false)
	private double value;
	
	@Column(nullable = false)
	private int quantity;

	public Game() {

	}


	public Game(String name, String description, double value, int quantity) {
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

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", quantity=" + quantity + "]";
	}
}

