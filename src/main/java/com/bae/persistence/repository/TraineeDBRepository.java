package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	// READ
	@Transactional(REQUIRED)
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT a from Trainee a");
		return util.getJSONForObject(query.getResultList())
		+ "{\"message\": \"here are all the trainees\"}";
	}

	// CREATE
	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been successfully added\"}";
	}

	// DELETE
	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(int traineeID) {
		Trainee delTrainee = manager.find(Trainee.class, traineeID);
		
		if (manager.contains(delTrainee)) {
			manager.remove(delTrainee);
			 return "{\"message\": \"Trainee " + traineeID +  " sucessfully deleted \"}";
		}
		return "{\"message\": \"No trainee found with this id.\"}";
	}

	// UPDATE - unresolved
	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(int traineeID, String trainee) {

		Trainee newTrainee = util.getObjectForJSON(trainee, Trainee.class);
		
		Trainee oldTrainee = manager.find(Trainee.class, traineeID);
		
	if (oldTrainee != null) {
			
			oldTrainee.setTraineeName(newTrainee.getTraineeName());
			
			manager.persist(oldTrainee);
		}
		return "{\"message\": \"trainee successfully updated\"}";
	}
}
