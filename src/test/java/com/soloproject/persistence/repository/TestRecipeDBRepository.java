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

import com.soloproject.persistence.domain.Recipe;
import com.soloproject.util.JSONUtil;
import com.soloproject.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class TestRecipeDBRepository {

	@InjectMocks
	private RecipeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final List<Recipe> RECIPES = new ArrayList<Recipe>();

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

//	@Test
//	public void testGetAllRecipes() {
//
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//
//		RECIPES.add(new Recipe(1, "recipe 1"));
//		RECIPES.add(new Recipe(2, "recipe 2"));
//
//		Mockito.when(query.getResultList()).thenReturn(RECIPES);
//		Assert.assertEquals(TestConstants.MOCK_JSON_ARRAY, repo.getAllRecipes());
//	}

	@Test
	public void testCreateRecipe() {

		String reply = repo.createRecipe(TestConstants.MOCK_JSON_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Recipe has been successfully added\"}");
	}

	@Test
	public void testDeleteRecipe() {

		Recipe tempIng = new Recipe();
		
		Mockito.when(manager.find(Recipe.class, 1)).thenReturn(tempIng);
		Mockito.when(manager.contains(tempIng)).thenReturn(true);
		String reply = repo.deleteRecipe(1);
		Assert.assertEquals("{\"message\": \"Recipe 1 successfully deleted\"}", reply);
	}

	@Test
	public void testDeleteRecipe2() {

		Recipe tempIng = new Recipe();
		
		Mockito.when(manager.find(Recipe.class, 1)).thenReturn(tempIng);

		// if the recipe doesn't exist

		Mockito.when(manager.contains(tempIng)).thenReturn(false);
		String reply = repo.deleteRecipe(1);
		Assert.assertEquals("{\"message\": \"No recipe found with id 1.\"}", reply);
	}

//	@Test
//	public void testFindRecipe() {
//		Mockito.when(manager.find(Recipe.class, 2)).thenReturn(testRoutine2);
//		Assert.assertEquals(testRoutine2Str, repo.getARoutine(2));
//	}

}