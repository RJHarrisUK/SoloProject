//
//package com.soloproject.business;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.soloproject.persistence.repository.IngredientDBRepository;
//import com.soloproject.persistence.repository.IngredientRepository;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class TestIngredientServiceImpl {
//
//	@Mock
//	private IngredientRepository ingredientRepo;
//	@InjectMocks
//	private IngredientDBRepository repo;
//
//	// CONSTANTS for testing
//	private static final String MOCK_OBJECT = "{\"ingredientId\":8,\"ingredientName\":\"Eggs\",\"calories\":300,\"totalFat\":19,\"totalCarbs\":21,\"protein\":25}";
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//	}
//
//	// CREATE test
//	@Test
//	public void testCreateIngredient() {
//
//		String reply = ingredientRepo.createIngredient(MOCK_OBJECT);
//
//		Assert.assertEquals(reply, "{\"message\": \"Ingredient has been successfully added\"}");
//	}
//
//}