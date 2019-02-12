package com.metehan.netas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metehan.netas.model.School;
import com.metehan.netas.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements ISchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);

	private List<School> list = new ArrayList<School>();
	
	
	@Override
	public List<School> getAllSchool() {
		List<School> list = new ArrayList<School>();
		for (School s : schoolRepository.findAll()) {
			list.add(s);
		}
		return list;
	}

	@Override
	public void saveSchool(School school) {
		schoolRepository.save(school);
	}

	@Override
	public boolean updateSchool(School school) {
		schoolRepository.save(school);
		return true;
	}

	@Override
	public boolean deleteSchool(School school) {
		if(schoolRepository.equals("")) {
			System.out.println("There is no any school");
		}
		else 
			schoolRepository.delete(school);
		return true;
	}
}
