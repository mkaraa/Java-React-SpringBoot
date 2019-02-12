package com.metehan.netas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metehan.netas.model.Instructor;
import com.metehan.netas.model.School;
import com.metehan.netas.repository.InstructorRepository;
import com.metehan.netas.repository.SchoolRepository;

@Service
public class InstructorServiceImpl implements IInstructorService{

	@Autowired
	private InstructorRepository InstructorRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);

	private List<Instructor> list = new ArrayList<Instructor>();
	
	School school = new School();
	Instructor ins = new Instructor();
	
	String  instructorSchoolName;
	
	
	@Override
	public List<Instructor> getAllInstructors() {
		List<Instructor> list = new ArrayList<Instructor>();
		for(Instructor i : InstructorRepository.findAll()) {
			list.add(i);
		}
		return list;
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		InstructorRepository.save(instructor); 
		
	}

	@Override
	public boolean updateInstructor(Instructor instructor) {
		InstructorRepository.save(instructor);
		return true;
	}

	@Override
	public boolean deleteInstructor(Instructor instructor) {	
		InstructorRepository.delete(instructor);
		return true;
	}

}
