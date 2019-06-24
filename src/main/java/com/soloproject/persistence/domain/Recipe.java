    
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
	@JoinTable(name = "RECIPES_INGREDIENTS", joinColumns = @JoinColumn(name = "RecipeId"), inverseJoinColumns = @JoinColumn(name = "IngredientId"))
	private Set<Ingredient> ingredientSet = new HashSet<>();

	// default constructor
	public Recipe() {
	}
	
	// constructor for tests
	public Recipe(int recipeId, String recipeName, Set<Ingredient> ingredientSet) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredientSet = ingredientSet;
	}
  
	// additional constructor for tests
	public Recipe(int recipeId, String recipeName) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
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

