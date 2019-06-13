package com.soloproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredient")
public class Ingredient {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int ingredient_id;
	@Column(length = 50)
	private String  ingredient_name;
	@Column(length = 50)
	private int calories;
	@Column(length = 50)
	private int total_fat;
	@Column(length = 50)
	private int total_carbs;
	@Column(length = 50)
	private int protein;

	// default constructor
	public Ingredient() {
	}

	// getters and setters
	public int getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public float getTotal_fat() {
		return total_fat;
	}

	public void setTotal_fat(int total_fat) {
		this.total_fat = total_fat;
	}

	public int getTotal_carbs() {
		return total_carbs;
	}

	public void setTotal_carbs(int total_carbs) {
		this.total_carbs = total_carbs;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public String getIngredient_name() {
		return ingredient_name;
	}

	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}

}
