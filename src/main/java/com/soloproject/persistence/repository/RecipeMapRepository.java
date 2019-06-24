package com.soloproject.persistence.repository;

import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.soloproject.persistence.domain.Recipe;
import com.soloproject.util.JSONUtil;

@Alternative
public class RecipeMapRepository implements RecipeRepository {

	@Inject
	JSONUtil util;
	Map<Integer, Recipe> recipeMap;
	Recipe newRecipe;

	// READ
	@Override
	public String getAllRecipes() {
		return util.getJSONForObject(recipeMap.values());
	}


	// CREATE
	@Override
	public String createRecipe(String recipe) {
		newRecipe = util.getObjectForJSON(recipe, Recipe.class);
		recipeMap.put(newRecipe.getRecipeId(), newRecipe);
		return "Recipe successfully created";
	}

	// DELETE
	@Override
	public String deleteRecipe(int recipeID) {
		recipeMap.remove(recipeID);
		return "Recipe successfully deleted";
	}

	// UPDATE
	@Override
	public String updateRecipe(int recipeID, String recipe) {
		Recipe upRecipe = util.getObjectForJSON(recipe, Recipe.class);

		if (recipeMap.containsKey(recipeID)) {
			recipeMap.replace(recipeID, upRecipe);
			return "Recipe added" + util.getJSONForObject(recipeMap.values());
		}
		return "Cannot update this recipe.";
	}

	// READ2
	@Override
	public String findRecipe(int recipeId) {
		return util.getJSONForObject(recipeMap.get(recipeId));
	}

	// getters and setters
	public Map<Integer, Recipe> getRecipeMap() {
		return recipeMap;
	}

	public void setIngredientMap(Map<Integer, Recipe> recipeMap) {
		this.recipeMap = recipeMap;
	}


	@Override
	public String addToRecipe(int recipeId, int ingredientId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String removeFromRecipe(int recipeId, int ingredientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
