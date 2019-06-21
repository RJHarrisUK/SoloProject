package com.soloproject.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.soloproject.persistence.domain.Ingredient;
import com.soloproject.persistence.domain.Recipe;
import com.soloproject.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	// READ
	@Override
	@Transactional(REQUIRED)
	public String getAllRecipes() {
		Query query = manager.createQuery("SELECT a from Recipe a");
		@SuppressWarnings("unchecked")
		Collection<Recipe> Recipes =  (Collection<Recipe>) query.getResultList();
		return util.getJSONForObject(Recipes);
	}

	// CREATE
	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipe aRecipe = util.getObjectForJSON(recipe, Recipe.class);
		manager.persist(aRecipe);
		return "{\"message\": \"Recipe has been successfully added\"}";
	}

	// DELETE
	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(int recipeId) {
		Recipe deleteRecipe = manager.find(Recipe.class, recipeId);
		
		if (manager.contains(deleteRecipe)) {
			manager.remove(deleteRecipe);
			  return "{\"message\": \"Recipe " + recipeId +  " sucessfully deleted \"}";
		}
		return "{\"message\": \"No recipe found with id " + recipeId + ".\"}";
	}

	// UPDATE
	@Override
	@Transactional(REQUIRED)
	public String updateRecipe(int recipeId, String recipe) {
		
		Recipe newRecipe = util.getObjectForJSON(recipe, Recipe.class);
		
		Recipe oldRecipe = manager.find(Recipe.class, recipeId);
		
		if (oldRecipe != null) {
			
			oldRecipe.setRecipeName(newRecipe.getRecipeName());

			manager.persist(oldRecipe);
		}
		return "{\"message\": \"Recipe successfully updated\"}";
	}
	
	// READ2
	@Override
	@Transactional(REQUIRED)
	public String findRecipe(int recipeId) {
		return util.getJSONForObject(manager.find(Recipe.class, recipeId));
	}	

	@Override
	@Transactional(REQUIRED)
	public String addToRecipe(int recipeId, int ingredientId) {
		Ingredient ingredientToAdd = manager.find(Ingredient.class, ingredientId);
		Recipe recipeToPopulate = manager.find(Recipe.class, recipeId);
		recipeToPopulate.getIngredientSet().add(ingredientToAdd);
		manager.persist(recipeToPopulate);
		return "{\"message\": \"Ingredient successfully added to Recipe\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String removeFromRecipe(int recipeId, int ingredientId) {
		Recipe recipeToDepopulate = manager.find(Recipe.class, recipeId);
		for (Ingredient ingredient : recipeToDepopulate.getIngredientSet()) {
			if (ingredient.getIngredientId() == ingredientId) {
				recipeToDepopulate.getIngredientSet().remove(ingredient);
				break;
			}
		}
		return "{\"message\": \"Ingredient successfully removed from Recipe\"}";
	}
	
	// getter and setter
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
}