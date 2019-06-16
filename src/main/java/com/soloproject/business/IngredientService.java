package com.soloproject.business;

public interface IngredientService {

	//CREATE
	String createIngredient(String ingredient);
	
	//READ
	String getAllIngredients();
	
	//UPDATE
	String updateIngredient(String ingredient, int ingredientId);
	
	//DELETE
	String deleteIngredient(int ingredientId);
	
	//READ2
	String findIngredient(int ingredientId);
}
