package com.soloproject.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecipe {

	private Recipe recipe = new Recipe(1, "Recipe 1");

	@Test
	public void getRecipeIdTest() {
		assertEquals(1, recipe.getRecipeId());
	}

	@Test
	public void getRecipeNameTest() {
		assertEquals("Recipe 1", recipe.getRecipeName());
	}
	
}
