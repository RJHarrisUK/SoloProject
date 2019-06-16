package com.soloproject.business;

import javax.inject.Inject;

import com.soloproject.persistence.repository.IngredientRepository;

public class IngredientServiceImpl implements IngredientService {

	@Inject
	private IngredientRepository ingredientRepo;

	@Override
	public String createIngredient(String ingredient) {
		return ingredientRepo.createIngredient(ingredient);
		}

	@Override
	public String getAllIngredients() {
		return ingredientRepo.getAllIngredients();
	}

	@Override
	public String updateIngredient(String ingredient, int ingredientId) {
		return ingredientRepo.updateIngredient(ingredientId, ingredient);
	}

	@Override
	public String deleteIngredient(int ingredientId) {
		return ingredientRepo.deleteIngredient(ingredientId);
	}

	@Override
	public String findIngredient(int ingredientId) {		
		return ingredientRepo.findIngredient(ingredientId);
	}

}
