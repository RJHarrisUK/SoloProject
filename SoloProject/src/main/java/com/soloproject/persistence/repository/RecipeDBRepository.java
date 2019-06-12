package com.soloproject.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
		Query query = manager.createQuery("SELECT a from Recipes a");
		return util.getJSONForObject(query.getResultList());
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
	public String deleteRecipe(int id) {
		Recipe deleteRecipe = manager.find(Recipe.class, id);
		
		if (manager.contains(deleteRecipe)) {
			manager.remove(deleteRecipe);
			  return "{\"message\": \"Recipe " + id +  " sucessfully deleted \"}";
		}
		return "{\"message\": \"No recipe found with id " + id + ".\"}";
	}

	// UPDATE
	@Override
	@Transactional(REQUIRED)
	public String updateRecipe(String recipe, int id) {
		
		Recipe newRecipe = util.getObjectForJSON(recipe, Recipe.class);
		
		Recipe oldRecipe = manager.find(Recipe.class, id);
		
		if (oldRecipe != null) {
			
			oldRecipe.setR_id(newRecipe.getR_id());

			manager.persist(oldRecipe);
		}
		return "{\"message\": \"Recipe successfully updated\"}";
	}

//	// READ2
//	@Override
//	@Transactional(REQUIRED)
//	public String findRecipe(int id) {
//		return util.getJSONForObject(manager.find(Recipe.class, id));
//
//	}
//	

}