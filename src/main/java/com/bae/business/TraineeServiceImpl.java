package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository traineeRepo;
	
	@Override
	public String getAllClassrooms() {
		return traineeRepo.getAllTrainees();
	}

	
	
}
