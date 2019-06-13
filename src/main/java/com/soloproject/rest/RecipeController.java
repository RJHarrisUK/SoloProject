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

@Path("/trainee")
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
	@Path("/deleteRecipe/{traineeID}")
	@DELETE
	@Produces({" application/json "})
	public String deleteRecipe(@PathParam("recipeID") int recipeID) {
		return service.deleteRecipe(recipeID);
	}
	
	// UPDATE
	@Path("/updateRecipe/{traineeID}")
	@PUT
	@Produces({" application/json "})
	public String updateRecipe(@PathParam("recipeID") String recipe, int recipeID) {
		return service.updateRecipe(recipe, recipeID);
	}
}
