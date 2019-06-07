package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository classRepo;

	@Override
	public String getAllClassrooms() {
		return classRepo.getAllClassrooms();
	}

	@Override
	public String createClassroom(String classroom) {
		return classRepo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(int id) {
		return classRepo.deleteClassroom(id);
	}

}
