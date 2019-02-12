package com.metehan.netas.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metehan.netas.model.Instructor;
import com.metehan.netas.model.School;
import com.metehan.netas.repository.InstructorRepository;
import com.metehan.netas.repository.SchoolRepository;






@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;


	public SchoolController(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@RequestMapping("/school")
	Collection<School> school() {
		return schoolRepository.findAll();
	}

	//For edit
	@PutMapping("/school")
	void update(@Valid @RequestBody String schoolId, String schoolName, String schoolAddress, String schoolPhone) {
		School school = schoolRepository.findOne(schoolId);
		school.setSchoolAddress(schoolAddress);
		school.setSchoolName(schoolName);
		school.setSchoolPhone(schoolPhone);
		schoolRepository.save(school);
	}
	
	@RequestMapping("/instructor")
	Collection<Instructor> instructors() { 
		return instructorRepository.findAll();
	}

	@GetMapping("/school/{schoolId}")
	School one(@PathVariable String schoolId) {
		return schoolRepository.findOne(schoolId);
	}
	
	@DeleteMapping("/school/{schoolId}")
    public ResponseEntity<?> deleteSchool(@PathVariable String schoolId) {
        School school = schoolRepository.findOne(schoolId);
        schoolRepository.delete(school);
        return ResponseEntity.ok().build();
    }


}
