package com.metehan.netas.service;

import java.util.*;

import com.metehan.netas.model.School;

public interface ISchoolService {
	
	List<School> getAllSchool();
	void saveSchool		(final School school);
	boolean updateSchool	(School school);
	boolean deleteSchool	(School school);
}
