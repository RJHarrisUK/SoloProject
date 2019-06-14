package com.soloproject.persistence.repository;

import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.soloproject.persistence.domain.Ingredient;
import com.soloproject.util.JSONUtil;

@Alternative
public class IngredientMapRepository implements IngredientRepository {

	@Inject
	JSONUtil util;
	Map<Integer, Ingredient> ingredientMap;
	Ingredient newIngredient;
	
	// READ
	@Override
	public String getAllIngredients() {
		return util.getJSONForObject(ingredientMap.values());
	}

	// CREATE
	@Override
	public String createIngredient(String ingredient) {
		newIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		ingredientMap.put(newIngredient.getIngredient_id(), newIngredient);
		return "Ingredient successfully created";
	}

	// DELETE
	@Override
	public String deleteIngredient(int ingredient_id) {
		ingredientMap.remove(ingredient_id);
		return "Ingredient successfully deleted";
	}

	// UPDATE
	@Override
	public String updateIngredient(String ingredient, int ingredient_id) {
		Ingredient upIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		
		if (ingredientMap.containsKey(ingredient_id)) {
			ingredientMap.replace(ingredient_id, upIngredient);
			return "Classroom added" + util.getJSONForObject(ingredientMap.values());
		}
		return "Cannot update this classroom.";
	}

	// READ2
	@Override
	public String findIngredient(int ingredient_id) {
		return util.getJSONForObject(ingredientMap.get(ingredient_id));
	}
	}
