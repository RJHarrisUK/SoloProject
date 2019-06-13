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
		recipeMap.put(newRecipe.getR_id(), newRecipe);
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
	public String updateRecipe(String recipe, int recipeID) {
		Recipe upRecipe = util.getObjectForJSON(recipe, Recipe.class);

		if (recipeMap.containsKey(recipeID)) {
			recipeMap.replace(recipeID, upRecipe);
			return "Recipe added" + util.getJSONForObject(recipeMap.values());
		}
		return "Cannot update this recipe.";
	}


}
