package com.bae.persistence.repository;

import java.util.Map;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	@Inject
	JSONUtil util;
	Map<Integer, Trainee> traineeMap;
	Trainee newTrainee;
	
	@Override
	public String getAllTrainees() {
		return util.getJSONForObject(traineeMap.values());
	}

	@Override
	public String createTrainee(String trainee) {
		newTrainee = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(newTrainee.getTraineeID(), newTrainee);
		return "Trainee successfully created";
	}

	@Override
	public String deleteTrainee(int traineeID) {
		traineeMap.remove(traineeID);
		return "Trainee successfully deleted";
	}

	@Override
	public String updateTrainee(int traineeID, String trainee) {
		Trainee upTrainee = util.getObjectForJSON(trainee, Trainee.class);
		
		if (traineeMap.containsKey(traineeID)) {
			traineeMap.replace(traineeID, upTrainee);
			return "Trainee added" + util.getJSONForObject(traineeMap.values());
		}
		return "Cannot update this trainee.";
	}


	}

