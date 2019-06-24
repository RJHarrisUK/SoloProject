package com.soloproject.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.soloproject.persistence.domain.Ingredient;
import com.soloproject.util.JSONUtil;

@Alternative
public class IngredientMapRepository implements IngredientRepository {

	private JSONUtil util;
	private Map<Integer, Ingredient> ingredientMap;
	private Ingredient newIngredient;

	public IngredientMapRepository() {
		this.ingredientMap = new HashMap<Integer, Ingredient>();
		util = new JSONUtil();
	}

	// READ
	@Override
	public String getAllIngredients() {
		return util.getJSONForObject(ingredientMap.values());
	}

	// CREATE
	@Override
	public String createIngredient(String ingredient) {
		newIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		ingredientMap.put(newIngredient.getIngredientId(), newIngredient);
		return "Ingredient successfully created";
	}


	// DELETE
	@Override
	public String deleteIngredient(int ingredientId) {
		ingredientMap.remove(ingredientId);
		return "Ingredient successfully deleted";
	}

	// UPDATE
	@Override
	public String updateIngredient(int ingredientId, String ingredient) {
		Ingredient upIngredient = util.getObjectForJSON(ingredient, Ingredient.class);

		if (ingredientMap.containsKey(ingredientId)) {
			ingredientMap.replace(ingredientId, upIngredient);
			return "Ingredient added" + util.getJSONForObject(ingredientMap.values());
		}
		return "Cannot update this ingredient.";
	}

	// READ2
	@Override
	public String findIngredient(int ingredientId) {
		return util.getJSONForObject(ingredientMap.get(ingredientId));
	}

	// getters and setters
	public Map<Integer, Ingredient> getIngredientMap() {
		return ingredientMap;
	}

	public void setIngredientMap(Map<Integer, Ingredient> ingredientMap) {
		this.ingredientMap = ingredientMap;
	}
}
