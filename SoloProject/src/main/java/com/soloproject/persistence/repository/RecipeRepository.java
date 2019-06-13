package com.soloproject.persistence.repository;

public interface RecipeRepository {

	//CREATE
	String createRecipe(String recipe);
	
	//READ
	String getAllRecipes();
	
	//UPDATE
	String updateRecipe(String recipe, int recipeID);
	
	//DESTROY
	String deleteRecipe(int recipeID);
	
}

