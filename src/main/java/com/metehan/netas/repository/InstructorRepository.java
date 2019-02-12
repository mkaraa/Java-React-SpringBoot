package com.metehan.netas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metehan.netas.model.Instructor;

@Repository("instructorRepository")
public interface InstructorRepository extends JpaRepository<Instructor, String> {

}
