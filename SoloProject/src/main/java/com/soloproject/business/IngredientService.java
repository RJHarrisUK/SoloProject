package com.soloproject.business;

public interface IngredientService {

	//CREATE
	String createIngredient(String ingredient);
	
	//READ
	String getAllIngredients();
	
	//UPDATE
	String updateIngredient(String ingredient, int id);
	
	//DELETE
	String deleteIngredient(int id);
	
	//READ2
	String findIngredient(int id);
}