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
import com.soloproject.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class IngredientDBRepository implements IngredientRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	// READ
	@Override
	@Transactional(REQUIRED)
	public String getAllIngredients() {
		// Ingredient must be first letter capitalised in JDBL
		Query query = manager.createQuery("SELECT a from Ingredient a");
		@SuppressWarnings("unchecked")
		Collection<Ingredient> Ingredients =  (Collection<Ingredient>) query.getResultList();
		return util.getJSONForObject(Ingredients);
	}

	// CREATE
	@Override
	@Transactional(REQUIRED)
	public String createIngredient(String ingredient) {
		Ingredient anIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		manager.persist(anIngredient);
		return "{\"message\": \"Ingredient has been successfully added\"}";
	}

	// DELETE
	@Override
	@Transactional(REQUIRED)
	public String deleteIngredient(int ingredientId) {
		Ingredient deleteIngredient = manager.find(Ingredient.class, ingredientId);
		
		if (manager.contains(deleteIngredient)) {
			manager.remove(deleteIngredient);
			  return "{\"message\": \"Ingredient " + ingredientId +  " successfully deleted\"}";
		}
		return "{\"message\": \"No ingredient found with id " + ingredientId + ".\"}";
	}

	// UPDATE
	@Override
	@Transactional(REQUIRED)
	public String updateIngredient(int ingredientId, String ingredient) {
		
		Ingredient newIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		
		Ingredient oldIngredient = manager.find(Ingredient.class, ingredientId);
		
		if (oldIngredient != null) {
			
			oldIngredient.setIngredientName(newIngredient.getIngredientName());
			oldIngredient.setCalories(newIngredient.getCalories());
			oldIngredient.setTotalFat(newIngredient.getTotalFat());
			oldIngredient.setTotalCarbs(newIngredient.getTotalCarbs());
			oldIngredient.setProtein(newIngredient.getProtein());

			manager.persist(oldIngredient);
		}
		return "{\"message\": \"Ingredient " + ingredientId +  " successfully updated\"}";
	}

	// READ2
	@Override
	@Transactional(REQUIRED)
	public String findIngredient(int ingredientId) {
		return util.getJSONForObject(manager.find(Ingredient.class, ingredientId));

	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
