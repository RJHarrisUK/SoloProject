package com.soloproject.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.soloproject.business.RecipeServiceImpl;
import com.soloproject.persistence.repository.RecipeRepository;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

	private String mockValue;
	private String mockValue2;

	@InjectMocks
	private RecipeServiceImpl service;

	@Mock
	private RecipeRepository repo;

	@Before
	public void setup() {
		mockValue = "testValue";
		mockValue2 = "testValue2";
	}

	@Test
	public void testGetAllRecipes() {
		Mockito.when(repo.getAllRecipes()).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.getAllRecipes());
	}

	@Test
	public void testCreateRecipe() {
		Mockito.when(repo.createRecipe(mockValue2)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.createRecipe(mockValue2));
		Mockito.verify(repo).createRecipe(mockValue2);
	}

	@Test
	public void testDeleteRecipe() {
		Mockito.when(repo.deleteRecipe(1)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.deleteRecipe(1));
		Mockito.verify(repo).deleteRecipe(1);
	}

}