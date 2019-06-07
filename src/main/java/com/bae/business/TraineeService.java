package com.bae.business;

public interface TraineeService {

	//CREATE
	String createTrainee(String trainee);
	
	//READ
	String getAllTrainees();
	
	//UPDATE - unresolved
	String updateTrainee(String trainee, int traineeID);
	
	//DESTROY
	String deleteTrainee(int traineeID);
	
}
