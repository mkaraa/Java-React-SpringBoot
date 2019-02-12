package com.metehan.netas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instructor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="instructorId", unique=true, nullable = false)
	public String instructorId;
	
	@Column(name="instructorName")
	public String instructorName;
	
	@Column(name="instructorSurname")
	public String instructorSurname;
	
	@Column(name="instructorBranch")
	public String instructorBranch;
	
	@Column(name="instructorAge")
	public String instructorAge;
	
	@Column(name="instructorPhone")
	public String instructorPhone;
	
	@Column(name="instructorSchoolName")
	public String instructorSchoolName;

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorid) {
		this.instructorId = instructorid;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorSurname() {
		return instructorSurname;
	}

	public void setInstructorSurname(String instructorSurname) {
		this.instructorSurname = instructorSurname;
	}

	public String getInstructorBranch() {
		return instructorBranch;
	}

	public void setInstructorBranch(String instructorBranch) {
		this.instructorBranch = instructorBranch;
	}

	public String getInstructorAge() {
		return instructorAge;
	}

	public void setInstructorAge(String instructorAge) {
		this.instructorAge = instructorAge;
	}

	public String getInstructorPhone() {
		return instructorPhone;
	}

	public void setInstructorPhone(String instructorPhone) {
		this.instructorPhone = instructorPhone;
	}

	public String getInstructorSchoolName() {
		return instructorSchoolName;
	}

	public void setInstructorSchoolName(String instructorSchoolName) {
		this.instructorSchoolName = instructorSchoolName;
	}

	public Instructor(String instructorId, String instructorName, String instructorSurname, String instructorBranch,
			String instructorAge, String instructorPhone, String instructorSchoolName) {
		super();
		this.instructorId = instructorId;
		this.instructorName = instructorName;
		this.instructorSurname = instructorSurname;
		this.instructorBranch = instructorBranch;
		this.instructorAge = instructorAge;
		this.instructorPhone = instructorPhone;
		this.instructorSchoolName = instructorSchoolName;
	}
	
	public Instructor() {
		
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", instructorName=" + instructorName
				+ ", instructorSurname=" + instructorSurname + ", instructorBranch=" + instructorBranch
				+ ", instructorAge=" + instructorAge + ", instructorPhone=" + instructorPhone + ""
						+ ", instructorSchoolName=" + instructorSchoolName + "]";
	}
	
	
	
	
	
	
}
