package com.soloproject.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.soloproject.business.IngredientService;

@Path("/ingredients")
public class IngredientController {

	@Inject
	private IngredientService service;

	// READ
	@Path("/getAllIngredients")
	@GET
	@Produces({ " application/json " })
	public String getAllIngredients() {
		return service.getAllIngredients();
	}

	// CREATE
	@Path("/createIngredient")
	@POST
	@Produces({ " application/json " })
	public String createIngredient(String ingredient) {
		return service.createIngredient(ingredient);
	}

	// DELETE
	@Path("/deleteIngredient/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteIngredient(@PathParam("id") int ingredientId) {
		return service.deleteIngredient(ingredientId);
	}

	// UPDATE
	@Path("/updateIngredient/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateIngredient(@PathParam("id") int ingredientId, String ingredient) {
		return service.updateIngredient(ingredient, ingredientId);
	}

	// READ
	@Path("/findIngredient/{id}")
	@GET
	@Produces({ "application/json" })
	public String findIngredient(@PathParam("id") int ingredientId) {
		return service.findIngredient(ingredientId);
	}
	// setter for tests
	public void setService(IngredientService service) {
		this.service = service;
	}
}
