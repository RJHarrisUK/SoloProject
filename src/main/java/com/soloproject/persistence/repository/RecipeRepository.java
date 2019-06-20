package com.soloproject.persistence.repository;

public interface RecipeRepository {

	//CREATE
	String createRecipe(String recipe);
	
	//READ
	String getAllRecipes();
	
	//UPDATE
	String updateRecipe(int recipeID, String recipe);
	
	//DELETE
	String deleteRecipe(int recipeID);

	//READ2
	String findRecipe(int recipeId);
	
}

