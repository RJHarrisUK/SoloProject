package com.soloproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int i_id;
	@Column(length = 50)
	private int calories;
	@Column(length = 50)
	private float total_fat;
	@Column(length = 50)
	private int total_carbs;
	@Column(length = 50)
	private int protein;

	// default constructor
	public Ingredient() {
	}

	// getters and setters
	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
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

	public void setTotal_fat(float total_fat) {
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

}
