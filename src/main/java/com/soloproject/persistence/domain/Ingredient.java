package com.soloproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// this must be first letter capitalised
@Table(name = "Ingredient")
public class Ingredient {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int ingredientId;
	@Column(length = 50)
	private String  ingredientName;
	@Column(length = 50)
	private int calories;
	@Column(length = 50)
	private int totalFat;
	@Column(length = 50)
	private int totalCarbs;
	@Column(length = 50)
	private int protein;

	// default constructor
	public Ingredient() {
	}

	// constructor for tests
	public Ingredient(int ingredientId, String ingredientName, int calories, int totalFat, int totalCarbs,
			int protein) {
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.calories = calories;
		this.totalFat = totalFat;
		this.totalCarbs = totalCarbs;
		this.protein = protein;
	}

	// getters and setters
	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(int totalFat) {
		this.totalFat = totalFat;
	}

	public int getTotalCarbs() {
		return totalCarbs;
	}

	public void setTotalCarbs(int totalCarbs) {
		this.totalCarbs = totalCarbs;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

}
