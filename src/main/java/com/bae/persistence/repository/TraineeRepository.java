package com.bae.persistence.repository;

public interface TraineeRepository {

	//C
	String createTrainee(String trainee);
	//R
	String getAllTrainees();
	//U	
	String updateTrainee(int traineeID, String trainee);
	//D
	String deleteTrainee(int traineeID);
}
