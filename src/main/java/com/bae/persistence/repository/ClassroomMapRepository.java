package com.bae.persistence.repository;

import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	@Inject
	JSONUtil util;
	Map<Integer, Classroom> classroomMap;
	Classroom newClassroom;
	
	// READ
	@Override
	public String getAllClassrooms() {
		return util.getJSONForObject(classroomMap.values());
	}

	// CREATE
	@Override
	public String createClassroom(String classroom) {
		newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(newClassroom.getId(), newClassroom);
		return "Classroom successfully created";
	}

	// DELETE
	@Override
	public String deleteClassroom(int id) {
		classroomMap.remove(id);
		return "Classroom successfully deleted";
	}

	// UPDATE - unresolved
	@Override
	public String updateClassroom(int id, String classroom) {
		Classroom upClassroom = util.getObjectForJSON(classroom, Classroom.class);
		
		if (classroomMap.containsKey(id)) {
			classroomMap.replace(id, upClassroom);
			return "Classroom added" + util.getJSONForObject(classroomMap.values());
		}
		return "Cannot update this classroom.";
	}
	}
