package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository traineeRepo;
	
	// READ
	@Override
	public String getAllTrainees() {
		return traineeRepo.getAllTrainees();
	}

	// CREATE
	@Override
	public String createTrainee(String trainee) {
		return traineeRepo.createTrainee(trainee);
	}

	// DELETE
	@Override
	public String deleteTrainee(int traineeID) {
		return traineeRepo.deleteTrainee(traineeID);
	}

	// UPDATE - unresolved
	@Override
	public String updateTrainee(String trainee, int traineeID) {
		return traineeRepo.updateTrainee(traineeID, trainee);
	}
	
}
