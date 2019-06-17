package com.soloproject.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.soloproject.persistence.domain.Ingredient;
import com.soloproject.persistence.repository.IngredientDBRepository;
import com.soloproject.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class IngredientDBRepositoryTest {

	@InjectMocks
	private IngredientDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	// CONSTANTS for testing
	private static final String MOCK_DATA_ARRAY = "[{\"ingredientId\":8,\"ingredientName\":\"Eggs\",\"calories\":300,\"totalFat\":19,\"totalCarbs\":21,\"protein\":25}]";

	private static final String MOCK_OBJECT = "{\"ingredientId\":\"8\",\"ingredientName\":\"Eggs\",\"calories\":\"300\",\"totalFat\":\"19\",\"totalCarbs\":\"21\",\"protein\":\"25\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllIngredients() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Ingredient> Ingredients = new ArrayList<Ingredient>();
		Ingredients.add(new Ingredient(8, "Eggs", 300, 19, 21, 25));
		Mockito.when(query.getResultList()).thenReturn(Ingredients);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllIngredients());
	}

	@Test
	public void testCreateIngredient() {
		String reply = repo.createIngredient(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Ingredient has been successfully added\"}");
	}

	@Test
	public void testDeleteIngredient() {
		
		Ingredient tempIng = new Ingredient();
		
		Mockito.when(manager.find(Ingredient.class,1)).thenReturn(tempIng);
		
		Mockito.when(manager.contains(tempIng)).thenReturn(true);
		
				String reply = repo.deleteIngredient(1);
		Assert.assertEquals( "{\"message\": \"Ingredient 1 successfully deleted\"}", reply);
	}
	
	@Test
	public void testDeleteIngredient2() {
		
		Ingredient tempIng = new Ingredient();
		
		Mockito.when(manager.find(Ingredient.class,1)).thenReturn(tempIng);
		
		//if the ingredient doesn't exist
		
		Mockito.when(manager.contains(tempIng)).thenReturn(false);
		
				String reply = repo.deleteIngredient(1);
		Assert.assertEquals( "{\"message\": \"No ingredient found with id 1.\"}", reply);
	}

}