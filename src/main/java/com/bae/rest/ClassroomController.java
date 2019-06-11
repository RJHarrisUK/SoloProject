package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.ClassroomService;

@Path("/classroom")
public class ClassroomController {

	@Inject
	private ClassroomService service;
	
	// READ
	@Path("/getAllClassrooms")
	@GET
	@Produces({" application/json "})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	// CREATE
	@Path("/createClassroom")
	@POST
	@Produces({" application/json "})
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	// DELETE
	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("id") int id) {
		return service.deleteClassroom(id);
}
	
	// UPDATE - unresolved
	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateClassroom(@PathParam("id") String classroom, int id) {
		return service.updateClassroom(classroom, id);
	}
	
	// READ
	@Path("/findClassroom/{id}")
	@GET
	@Produces({"application/json"})
	public String findClassroom(@PathParam("id") int id) {
		return service.findClassroom(id);
	}
}
