package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.ClassroomService;

@Path("/classroom")
public class ClassroomController {

	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({" application/json "})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
}
