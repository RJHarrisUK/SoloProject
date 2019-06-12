package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	// READ
	@Override
	@Transactional(REQUIRED)
	public String getAllClassrooms() {
		Query query = manager.createQuery("SELECT a from Classroom a");
		return util.getJSONForObject(query.getResultList());
	}

	// CREATE
	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been successfully added\"}";
	}

	// DELETE
	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(int id) {
		Classroom delClassroom = manager.find(Classroom.class, id);
		
		if (manager.contains(delClassroom)) {
			manager.remove(delClassroom);
			  return "{\"message\": \"Classroom " + id +  " sucessfully deleted \"}";
		}
		return "{\"message\": \"No classroom found with id " + id + ".\"}";
	}

	// UPDATE - unresolved
	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(int id, String classroom) {
		
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		
		Classroom oldClassroom = manager.find(Classroom.class, id);
		
		if (oldClassroom != null) {
			
			oldClassroom.setTrainer(newClassroom.getTrainer());

			manager.persist(oldClassroom);
		}
		return "{\"message\": \"classroom successfully updated\"}";
	}

	// READ2
	@Override
	@Transactional(REQUIRED)
	public String findClassroom(int id) {
		return util.getJSONForObject(manager.find(Classroom.class, id));

	}
	

}
