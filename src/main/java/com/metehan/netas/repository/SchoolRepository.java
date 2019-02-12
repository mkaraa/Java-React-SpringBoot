package com.metehan.netas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metehan.netas.model.Instructor;
import com.metehan.netas.model.School;

@Repository("schoolRepository")
public interface SchoolRepository extends JpaRepository<School, String> {

	public Instructor getBySchoolName(final String schoolName);

}
