package com.soloproject.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
//this must be first letter capitalised
@Table(name = "Recipe")
public class Recipe {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int recipeId;
	@Column(length = 50)
	private String recipeName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "recipes_ingredients", joinColumns = @JoinColumn(name = "recipeId"), inverseJoinColumns = @JoinColumn(name = "ingredientId"))
	private Set<Ingredient> ingredientSet = new HashSet<>();

	// default constructor
	public Recipe() {
	}

	// getters and setters
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	// table join getter and setter for ingredient map
	public Set<Ingredient> getIngredientSet() {
		return ingredientSet;
	}

	public void setIngredientSet(Set<Ingredient> ingredientSet) {
		this.ingredientSet = ingredientSet;
	}
}
