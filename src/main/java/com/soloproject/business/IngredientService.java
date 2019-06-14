package com.soloproject.business;

public interface IngredientService {

	//CREATE
	String createIngredient(String ingredient);
	
	//READ
	String getAllIngredients();
	
	//UPDATE
	String updateIngredient(String ingredient, int ingredient_id);
	
	//DELETE
	String deleteIngredient(int ingredient_id);
	
	//READ2
	String findIngredient(int ingredient_id);
}
