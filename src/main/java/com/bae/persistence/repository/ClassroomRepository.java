package com.bae.persistence.repository;

public interface ClassroomRepository {

	// CREATE
	String createClassroom(String classroom);

	// READ
	String getAllClassrooms();

	// UPDATE - unresolved
	String updateClassroom(int id, String classroom);

	// DESTROY
	String deleteClassroom(int id);
}
