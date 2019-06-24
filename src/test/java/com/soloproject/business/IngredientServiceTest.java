package com.soloproject.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import com.soloproject.persistence.repository.IngredientRepository;


@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTest {

	private String mockValue;
	private String mockValue2;

	@InjectMocks
	private IngredientServiceImpl service;

	@Mock
	private IngredientRepository repo;

	@Before
	public void setup() {
		mockValue = "testValue";
		mockValue2 = "testValue2";
	}

	@Test
	public void testGetAllIngredients() {
		Mockito.when(repo.getAllIngredients()).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.getAllIngredients());
	}

	@Test
	public void testCreateIngredient() {
		Mockito.when(repo.createIngredient(mockValue2)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.createIngredient(mockValue2));
		Mockito.verify(repo).createIngredient(mockValue2);
	}

	@Test
	public void testDeleteIngredient() {
		Mockito.when(repo.deleteIngredient(1)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, service.deleteIngredient(1));
		Mockito.verify(repo).deleteIngredient(1);
	}

}