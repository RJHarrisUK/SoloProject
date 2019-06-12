package com.soloproject.business;

public interface RecipeService {

	//CREATE
	String createRecipe(String trainee);
	
	//READ
	String getAllRecipes();
	
	//UPDATE
	String updateRecipe(String trainee, int traineeID);
	
	//DESTROY
	String deleteRecipe(int traineeID);
	
}
