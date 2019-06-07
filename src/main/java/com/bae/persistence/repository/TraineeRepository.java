package com.bae.persistence.repository;

public interface TraineeRepository {

	// CREATE
	String createTrainee(String trainee);

	// READ
	String getAllTrainees();

	// UPDATE - unresolved
	String updateTrainee(int traineeID, String trainee);

	// DESTROY
	String deleteTrainee(int traineeID);
}
