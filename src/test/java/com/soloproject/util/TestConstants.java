package com.soloproject.util;

import com.soloproject.persistence.domain.Ingredient;

public class TestConstants {
	
	public static final Ingredient TEST_JAVA_OBJECT = new Ingredient(1, "tofu", 234, 23, 21, 20);
	
	public static final Ingredient TEST_JAVA_OBJECT_2 = new Ingredient(2, "miso", 875, 92, 34, 57);
	
	public static final String MOCK_JSON_ARRAY = "[{\"ingredientId\":1,\"ingredientName\":\"tofu\",\"calories\":234,\"totalFat\":23,\"totalCarbs\":21,\"protein\":20},{\"ingredientId\":2,\"ingredientName\":\"miso\",\"calories\":875,\"totalFat\":92,\"totalCarbs\":34,\"protein\":57}]";
	
	public static final String MOCK_JSON_OBJECT = "{\"ingredientId\":1,\"ingredientName\":\"tofu\",\"calories\":234,\"totalFat\":23,\"totalCarbs\":21,\"protein\":20}";
	
	public static final String MOCK_UPDATE_STRING = "{\"ingredientId\":1,\"ingredientName\":\"tofu\",\"calories\":334,\"totalFat\":32,\"totalCarbs\":12,\"protein\":30}";
	
	public static final String MOCK_JSON_OBJECT_2 = "{\"ingredientId\":2,\"ingredientName\":\"miso\",\"calories\":875,\"totalFat\":92,\"totalCarbs\":34,\"protein\":57}";
	
	public static final String SUCCESS_MESSAGE = "Ingredient successfully created";
	
	public static final String DELETE_MESSAGE = "Ingredient successfully deleted";
}

	

