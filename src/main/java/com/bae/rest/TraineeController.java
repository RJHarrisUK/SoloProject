package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.TraineeService;

@Path("/trainee")
public class TraineeController {

	@Inject TraineeService service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({" application/json "})
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	@Path("/createTrainee")
	@POST
	@Produces({" application/json "})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
}
