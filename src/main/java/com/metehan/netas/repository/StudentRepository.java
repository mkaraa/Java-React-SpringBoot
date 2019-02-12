package com.metehan.netas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metehan.netas.model.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, String>{

}
