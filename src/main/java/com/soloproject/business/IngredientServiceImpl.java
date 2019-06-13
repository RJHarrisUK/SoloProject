package com.soloproject.business;

import javax.inject.Inject;

import com.soloproject.persistence.repository.IngredientRepository;

public class IngredientServiceImpl implements IngredientService {

	@Inject
	private IngredientRepository ingredientRepo;
//
//	// READ
//	@Override
//	public String getAllClassrooms() {
//		return classRepo.getAllClassrooms();
//	}
//
//	// CREATE
//	@Override
//	public String createClassroom(String classroom) {
//		return classRepo.createClassroom(classroom);
//	}
//
//	// DELETE
//	@Override
//	public String deleteClassroom(int id) {
//		return classRepo.deleteClassroom(id);
//	}
//
//	// UPDATE - unresolved
//	@Override
//	public String updateClassroom(String classroom, int id) {
//		return classRepo.updateClassroom(id, classroom);
//	}
//
//	// READ2
//	@Override
//	public String findClassroom(int id) {
//		return classRepo.findClassroom(id);
//	}

	@Override
	public String createIngredient(String ingredient) {
		return ingredientRepo.createIngredient(ingredient);
		}

	@Override
	public String getAllIngredients() {
		return ingredientRepo.getAllIngredients();
	}

	@Override
	public String updateIngredient(String ingredient, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteIngredient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findIngredient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
