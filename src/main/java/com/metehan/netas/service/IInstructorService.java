package com.metehan.netas.service;

import java.util.List;

import com.metehan.netas.model.Instructor;

public interface IInstructorService {
	
	List<Instructor> getAllInstructors();
	
	void saveInstructor (final Instructor instructor);
	boolean updateInstructor (Instructor instructor);
	boolean deleteInstructor (Instructor instructor);
}
