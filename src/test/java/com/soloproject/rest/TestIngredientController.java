
package com.soloproject.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.soloproject.business.IngredientService;

@RunWith(MockitoJUnitRunner.class)
public class TestIngredientController {

	private String mockValue;
	private String mockValue2;

	@InjectMocks
	private IngredientController controller;
	// Class under test

	@Mock
	private IngredientService service;

	@Before
	public void setup() {
		controller.setService(service);
		mockValue = "testValue";
	}

	@Test
	public void testGetAllIngredients() {
		Mockito.when(service.getAllIngredients()).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.getAllIngredients());
	}

	@Test
	public void testCreateIngredients() {
		Mockito.when(service.createIngredient(mockValue2)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.createIngredient(mockValue2));
		Mockito.verify(service).createIngredient(mockValue2);
	}

	@Test
	public void testDeleteIngredient() {
		Mockito.when(service.deleteIngredient(1)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.deleteIngredient(1));
		Mockito.verify(service).deleteIngredient(1);
	}

}