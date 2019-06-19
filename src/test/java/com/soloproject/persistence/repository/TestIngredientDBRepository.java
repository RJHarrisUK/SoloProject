
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
import com.soloproject.util.JSONUtil;
import com.soloproject.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class TestIngredientDBRepository {

	@InjectMocks
	private IngredientDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final List<Ingredient> INGREDIENTS = new ArrayList<Ingredient>();

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllIngredients() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		INGREDIENTS.add(new Ingredient(1, "tofu", 234, 23, 21, 20));
		INGREDIENTS.add(new Ingredient(2, "miso", 875, 92, 34, 57));

		Mockito.when(query.getResultList()).thenReturn(INGREDIENTS);
		Assert.assertEquals(TestConstants.MOCK_JSON_ARRAY, repo.getAllIngredients());
	}

	@Test
	public void testCreateIngredient() {

		String reply = repo.createIngredient(TestConstants.MOCK_JSON_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Ingredient has been successfully added\"}");
	}

	@Test
	public void testDeleteIngredient() {

		Ingredient tempIng = new Ingredient();
		
		Mockito.when(manager.find(Ingredient.class, 1)).thenReturn(tempIng);
		Mockito.when(manager.contains(tempIng)).thenReturn(true);
		String reply = repo.deleteIngredient(1);
		Assert.assertEquals("{\"message\": \"Ingredient 1 successfully deleted\"}", reply);
	}

	@Test
	public void testDeleteIngredient2() {

		Ingredient tempIng = new Ingredient();
		
		Mockito.when(manager.find(Ingredient.class, 1)).thenReturn(tempIng);

		// if the ingredient doesn't exist

		Mockito.when(manager.contains(tempIng)).thenReturn(false);
		String reply = repo.deleteIngredient(1);
		Assert.assertEquals("{\"message\": \"No ingredient found with id 1.\"}", reply);
	}

	@Test
	public void testFindIngredient() {

		Mockito.when(manager.find(Ingredient.class, 1)).thenReturn(INGREDIENTS.get(0));
		String reply = repo.findIngredient(1);
		Assert.assertEquals(TestConstants.MOCK_JSON_OBJECT, reply);
	}

}