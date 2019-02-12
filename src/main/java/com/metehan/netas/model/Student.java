package com.metehan.netas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id", unique=true, nullable=false)
	public String id;
	
	@Column(name="name",nullable=false)
	public String name;
	
	@Column(name="surname", nullable=false)
	public String surname;
	
	@Column(name="mobilePhone")
	public int mobilePhone;

	@Column(name="city")
	public String city;
	
	@Column(name="district")
	public String district;
	
	public Student() {
		
	}

	public Student(String id, String name, String surname, int mobilePhone, String city, String district) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mobilePhone = mobilePhone;
		this.city = city;
		this.district = district;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", mobilePhone=" + mobilePhone
				+ ", city=" + city + ", district=" + district + "]";
	}
	
}
