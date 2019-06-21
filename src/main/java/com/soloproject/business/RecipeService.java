package com.soloproject.business;

public interface RecipeService {

	//CREATE
	String createRecipe(String recipe);
	
	//READ
	String getAllRecipes();
	
	//UPDATE
	String updateRecipe(String recipe, int recipeID);
	
	//DESTROY
	String deleteRecipe(int recipeID);
	
	//READ2
	String findRecipe(int recipeId);
	
	// CREATE (JOINT)
	String addToRecipe(int recipeId, int ingredientId);

	// DELETE (JOINT)
	String removeFromRecipe(int recipeId, int ingredientId);
	
}
