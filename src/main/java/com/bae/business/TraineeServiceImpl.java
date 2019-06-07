package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository traineeRepo;
	
	@Override
	public String getAllTrainees() {
		return traineeRepo.getAllTrainees();
	}

	@Override
	public String createTrainee(String trainee) {
		return traineeRepo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(int traineeID) {
		return traineeRepo.deleteTrainee(traineeID);
	}

	@Override
	public String updateTrainee(String trainee, int traineeID) {
		return traineeRepo.updateTrainee(traineeID, trainee);
	}
	
}
