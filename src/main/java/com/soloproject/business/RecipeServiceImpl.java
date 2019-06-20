package com.soloproject.business;

import javax.inject.Inject;

import com.soloproject.persistence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeRepository recipeRepo;
	
	@Override
	public String createRecipe(String recipe) {
		return recipeRepo.createRecipe(recipe);
	}

	@Override
	public String getAllRecipes() {
		return recipeRepo.getAllRecipes();
	}

	@Override
	public String updateRecipe(String recipe, int recipeId) {
		return recipeRepo.updateRecipe(recipeId, recipe);
	}

	@Override
	public String deleteRecipe(int recipeId) {
		return recipeRepo.deleteRecipe(recipeId);
	}

	@Override
	public String findRecipe(int recipeId) {
		return recipeRepo.findRecipe(recipeId);
	}
	
}
