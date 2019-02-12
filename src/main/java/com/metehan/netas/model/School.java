package com.metehan.netas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "schoolId", nullable = false)
	public String schoolId;

	@Column(name = "schoolName", nullable = false)
	public String schoolName;

	@Column(name = "schoolAddress", nullable = false)
	public String schoolAddress;

	@Column(name = "schoolPhone", nullable = false)
	public String schoolPhone;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public School(String schoolId, String schoolName, String schoolAddress, String schoolPhone) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.schoolPhone = schoolPhone;
	}

	public School() {

	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
				+ ", schoolPhone=" + schoolPhone + "]";
	}

}
