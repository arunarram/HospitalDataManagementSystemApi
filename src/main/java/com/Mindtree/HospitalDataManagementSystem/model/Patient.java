package com.Mindtree.HospitalDataManagementSystem.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String visitedDoctor;

	@Column(nullable = false, columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfVisit;

	@Column(nullable = false)
	private String prescription;

	public Patient() {
		super();
	}

	public Patient(String name, String visitedDoctor, Date dateOfVisit, String prescription) {
		super();
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return id == other.id;
	}

}
