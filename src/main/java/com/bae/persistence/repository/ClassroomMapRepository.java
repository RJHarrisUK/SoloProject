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
	
	@Override
	public String getAllClassrooms() {
		return util.getJSONForObject(classroomMap.values());
	}

}
