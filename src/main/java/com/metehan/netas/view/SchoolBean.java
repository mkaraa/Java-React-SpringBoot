package com.metehan.netas.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ViewScoped;
import javax.persistence.Column;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metehan.netas.model.School;
import com.metehan.netas.service.ISchoolService;

@Component
@ViewScoped
public class SchoolBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SchoolBean.class);
	
	@Autowired
	private ISchoolService schoolService;
	private School school;
	
	private List<School> schools;
	
	private School selectedSchool;
	private boolean res;
	
	
	public String schoolId;
	public String schoolName;
	public String schoolAddress;
	public String schoolPhone;
	
	
	public void save() throws IOException{
		if (school.getSchoolId() != null && school.getSchoolId().equalsIgnoreCase("") ||
			school.getSchoolName() != null && school.getSchoolName().equalsIgnoreCase("") ||
			school.getSchoolAddress() != null && school.getSchoolAddress().equalsIgnoreCase("") ||
			school.getSchoolPhone() != null && school.getSchoolPhone().equalsIgnoreCase("")) {
			
			logger.info("New School is Added ." , this.school);
			
			this.schoolService.saveSchool(school);
			
		}
	}
	
	
	public SchoolBean() {
		super();
	}
	
	public void delete(School school) { 
		this.schoolService.deleteSchool(school);
	}
	
	public void update(School school) { 
		this.schoolService.updateSchool(school);
	}

	public ISchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public School getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(School selectedSchool) {
		this.selectedSchool = selectedSchool;
	}

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	
	
	
	
	
	
	
	
	
}
