package com.bae.persistence.repository;

import java.util.Map;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	@Inject
	JSONUtil util;
	Map<Integer, Trainee> traineeMap;
	
	@Override
	public String getAllTrainees() {
		return util.getJSONForObject(traineeMap.values());
	}


	}

