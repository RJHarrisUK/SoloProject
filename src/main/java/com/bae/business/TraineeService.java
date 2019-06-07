package com.bae.business;

public interface TraineeService {

	//C
	String createTrainee(String trainee);
	//R
	String getAllTrainees();
	//U
	String updateTrainee(String trainee, int traineeID);
	//D
	String deleteTrainee(int traineeID);
	
}
