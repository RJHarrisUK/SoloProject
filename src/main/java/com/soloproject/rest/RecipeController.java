package com.soloproject.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.soloproject.business.RecipeService;

@Path("/recipes")
public class RecipeController {

	@Inject RecipeService service;
	
	// READ
	@Path("/getAllRecipes")
	@GET
	@Produces({" application/json "})
	public String getAllRecipes() {
		return service.getAllRecipes();
	}
	
	// CREATE
	@Path("/createRecipe")
	@POST
	@Produces({" application/json "})
	public String createRecipe(String recipe) {
		return service.createRecipe(recipe);
	}
	
	// DELETE
	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({" application/json "})
	public String deleteRecipe(@PathParam("id") int recipeId) {
		return service.deleteRecipe(recipeId);
	}
	
	// UPDATE
	@Path("/updateRecipe/{id}")
	@PUT
	@Produces({" application/json "})
	public String updateRecipe(@PathParam("id") int recipeId, String recipe) {
		return service.updateRecipe(recipe, recipeId);
	}
	
	// CREATE (JOINT)
	@Path("/addToRecipe/{recipeId}/{ingredientId}")
	@POST
	@Produces({" application/json "})
	String addToRecipe(@PathParam("recipeId") int recipeId, @PathParam("ingredientId") int ingredientId) {
		return service.addToRecipe(recipeId, ingredientId);
	}
	
	// DELETE (JOINT)
	@Path("/removeFromRecipe/{recipeId}/{ingredientId}")
	@DELETE
	@Produces({" application/json "})
	String removeFromRecipe(@PathParam("recipeId") int recipeId, @PathParam("ingredientId") int ingredientId) {
		return service.removeFromRecipe(recipeId, ingredientId);
	}
	
}
