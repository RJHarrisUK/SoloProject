package com.soloproject.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

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
		Query query = manager.createQuery("SELECT a from Ingredient a");
		return util.getJSONForObject(query.getResultList());
	}

	// CREATE
	@Override
	@Transactional(REQUIRED)
	public String createIngredient(String ingredient) {
		Ingredient anIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		manager.persist(anIngredient);
		return "{\"message\": \"ingredient has been successfully added\"}";
	}

	// DELETE
	@Override
	@Transactional(REQUIRED)
	public String deleteIngredient(int id) {
		Ingredient deleteIngredient = manager.find(Ingredient.class, id);
		
		if (manager.contains(deleteIngredient)) {
			manager.remove(deleteIngredient);
			  return "{\"message\": \"Ingredient " + id +  " sucessfully deleted \"}";
		}
		return "{\"message\": \"No ingredient found with id " + id + ".\"}";
	}

	// UPDATE
	@Override
	@Transactional(REQUIRED)
	public String updateIngredient(String ingredient, int id) {
		
		Ingredient newIngredient = util.getObjectForJSON(ingredient, Ingredient.class);
		
		Ingredient oldIngredient = manager.find(Ingredient.class, id);
		
		if (oldIngredient != null) {
			
			oldIngredient.setIngredient_id(newIngredient.getIngredient_id());

			manager.persist(oldIngredient);
		}
		return "{\"message\": \"Ingredient successfully updated\"}";
	}

	// READ2
	@Override
	@Transactional(REQUIRED)
	public String findIngredient(int id) {
		return util.getJSONForObject(manager.find(Ingredient.class, id));

	}
	

}
