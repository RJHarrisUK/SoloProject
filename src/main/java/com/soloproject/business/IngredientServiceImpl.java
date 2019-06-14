package com.soloproject.business;

import javax.inject.Inject;

import com.soloproject.persistence.repository.IngredientRepository;

public class IngredientServiceImpl implements IngredientService {

	@Inject
	private IngredientRepository ingredientRepo;

//
//	// UPDATE - unresolved
//	@Override
//	public String updateClassroom(String classroom, int id) {
//		return classRepo.updateClassroom(id, classroom);
//	}
//


	@Override
	public String createIngredient(String ingredient) {
		return ingredientRepo.createIngredient(ingredient);
		}

	@Override
	public String getAllIngredients() {
		return ingredientRepo.getAllIngredients();
	}

	@Override
	public String updateIngredient(String ingredient, int ingredient_id) {
		return null;
	}

	@Override
	public String deleteIngredient(int ingredient_id) {
		return ingredientRepo.deleteIngredient(ingredient_id);
	}

	@Override
	public String findIngredient(int ingredient_id) {		
		return ingredientRepo.findIngredient(ingredient_id);
	}

}
