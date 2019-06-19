package com.soloproject.persistence.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.soloproject.util.JSONUtil;
import com.soloproject.util.TestConstants;

public class TestIngredientMapRepository {
	
	private static IngredientMapRepository imr = new IngredientMapRepository();
	private JSONUtil jsonUtil = new JSONUtil();

//	@Before
//	public  void setup() {
////		imr = new IngredientMapRepository();
//	}
//	 READ (All)
	@Test
	public void getAllIngredientsTest() {
		assertEquals(TestConstants.MOCK_JSON_ARRAY, imr.getAllIngredients());
	}

	//	READ (Specific)
	@Test
	public void getIngredientTest() {
		imr.getIngredientMap().put(1, TestConstants.TEST_JAVA_OBJECT);
		assertEquals("[" + TestConstants.MOCK_JSON_OBJECT + "]", imr.getAllIngredients());
	}

	// READ (Specific from several in map)
	@Test
	public void findIngredientTest() {
		imr.getIngredientMap().put(1, TestConstants.TEST_JAVA_OBJECT);
		imr.getIngredientMap().put(2, TestConstants.TEST_JAVA_OBJECT_2);
		assertEquals(TestConstants.MOCK_JSON_OBJECT_2, imr.findIngredient(2));
	}

// READ (Empty map)
	@Test
	public void getIngredientEmptyMapTest() {
		assertEquals("null", imr.findIngredient(2));
	}
//
//	// CREATE 
//	@Test
//	public void createIngredientTest() {
//		imr.createIngredient(TestConstants.MOCK_JSON_OBJECT);
//		assertEquals(1, imr.getIngredientMap().size());
//	}
}
