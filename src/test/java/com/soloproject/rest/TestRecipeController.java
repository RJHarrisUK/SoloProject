package com.soloproject.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.soloproject.business.RecipeService;

@RunWith(MockitoJUnitRunner.class)
public class TestRecipeController {
	

	private String mockValue;
	private String mockValue2;

	@InjectMocks
	private RecipeController controller;
	// Class under test

	@Mock
	private RecipeService service;

	@Before
	public void setup() {
		controller.setService(service);
		mockValue = "testValue";
		mockValue2 = "testValue2";
	}

	@Test
	public void testGetAllRecipes() {
		Mockito.when(service.getAllRecipes()).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.getAllRecipes());
	}

	@Test
	public void testCreateRecipes() {
		Mockito.when(service.createRecipe(mockValue2)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.createRecipe(mockValue2));
		Mockito.verify(service).createRecipe(mockValue2);
	}

	@Test
	public void testDeleteRecipe() {
		Mockito.when(service.deleteRecipe(1)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.deleteRecipe(1));
		Mockito.verify(service).deleteRecipe(1);
	}
	
//	@Test
//	public void testUpdateRecipe() {
//		Mockito.when(service.findRecipe(1)).thenReturn(mockValue);
//		Assert.assertEquals(mockValue2, controller.updateRecipe(1, mockValue2));
//	}
}
