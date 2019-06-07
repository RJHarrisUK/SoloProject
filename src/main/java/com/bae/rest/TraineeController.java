package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.TraineeService;

@Path("/trainee")
public class TraineeController {

	@Inject TraineeService service;
	
	
	// READ
	@Path("/getAllTrainees")
	@GET
	@Produces({" application/json "})
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	// CREATE
	@Path("/createTrainee")
	@POST
	@Produces({" application/json "})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	// DELETE
	@Path("/deleteTrainee/{traineeID}")
	@DELETE
	@Produces({" application/json "})
	public String deleteTrainee(@PathParam("traineeID") int traineeID) {
		return service.deleteTrainee(traineeID);
	}
	
	// UPDATE - unresolved
	@Path("/updateTrainee/{traineeID}")
	@PUT
	@Produces({" application/json "})
	public String updateTrainee(@PathParam("traineeID") String trainee, int traineeID) {
		return service.updateTrainee(trainee, traineeID);
	}
}
