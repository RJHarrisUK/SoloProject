package com.bae.business;

public interface ClassroomService {

	//CREATE
	String createClassroom(String classroom);
	
	//READ
	String getAllClassrooms();
	
	//UPDATE - unresolved
	String updateClassroom(String classroom, int id);
	
	//DESTROY 
	String deleteClassroom(int id);
}
