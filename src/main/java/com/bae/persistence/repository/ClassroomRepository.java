 package com.bae.persistence.repository;

public interface ClassroomRepository {

	//C
	String createClassroom(String classroom);
	//R
	String getAllClassrooms();
	//U	
	String updateClassroom(int id, String classroom);
	//D
	String deleteClassroom(int id);
}
