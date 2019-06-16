package com.soloproject.persistence.repository;

public interface IngredientRepository {

	//CREATE
	String createIngredient(String ingredient);
	
	//READ
	String getAllIngredients();
	
	//UPDATE
	String updateIngredient(int ingredientId, String ingredient);
	
	//DELETE
	String deleteIngredient(int ingredientId);
	
	//READ2
	String findIngredient(int ingredientId);
}
