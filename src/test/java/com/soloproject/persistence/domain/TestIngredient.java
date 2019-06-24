package com.soloproject.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIngredient {

	private Ingredient ingredient = new Ingredient(1, "tofu", 234, 23, 21, 20);

	@Test
	public void getIngredientIdTest() {
		assertEquals(1, ingredient.getIngredientId());
	}

	@Test
	public void getCaloriesTest() {
		assertEquals(234, ingredient.getCalories());
	}

	@Test
	public void getTotalFatTest() {
		assertEquals(23, ingredient.getTotalFat());
	}

	@Test
	public void getTotalCarbsTest() {
		assertEquals(21, ingredient.getTotalCarbs());
	}

	@Test
	public void getProteinTest() {
		assertEquals(20, ingredient.getProtein());
	}
	
	@Test
	public void getIngredientNameTest() {
		assertEquals("tofu", ingredient.getIngredientName());
	}
}
