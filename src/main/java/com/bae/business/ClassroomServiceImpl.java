package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository classRepo;

	// READ
	@Override
	public String getAllClassrooms() {
		return classRepo.getAllClassrooms();
	}

	// CREATE
	@Override
	public String createClassroom(String classroom) {
		return classRepo.createClassroom(classroom);
	}

	// DELETE
	@Override
	public String deleteClassroom(int id) {
		return classRepo.deleteClassroom(id);
	}

	// UPDATE - unresolved
	@Override
	public String updateClassroom(String classroom, int id) {
		return classRepo.updateClassroom(id, classroom);
	}

	// READ2
	@Override
	public String findClassroom(int id) {
		return classRepo.findClassroom(id);
	}

}
