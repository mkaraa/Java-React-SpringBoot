package com.metehan.netas.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.metehan.netas.model.Instructor;
import com.metehan.netas.model.School;
import com.metehan.netas.repository.InstructorRepository;
import com.sun.faces.action.RequestMapping;

@RestController
@RequestMapping("api")	
public class InstructorController {

	private InstructorRepository instructorRepository;
	
	public InstructorController(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	
	@GetMapping("/instructor/{instructorId}")
	Instructor one(@PathVariable String instructorId) {
		return instructorRepository.findOne(instructorId);
	}
	
	@DeleteMapping("/instructor/{instructorId}")
	public ResponseEntity<?> deleteInstructor(@PathVariable String instructorId) { 
		Instructor ins = instructorRepository.findOne(instructorId);
		instructorRepository.delete(ins);
		return ResponseEntity.ok().build();
	}
}
