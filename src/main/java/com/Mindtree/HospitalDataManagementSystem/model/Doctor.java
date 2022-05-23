package com.Mindtree.HospitalDataManagementSystem.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private Gender gender;

	@Column(nullable = false)
	private String specialist;

	@Column(nullable = false)
	private long numberOfPatientsVisited = 0;

	public Doctor() {
		super();
	}

	public Doctor(String name, int age, Gender gender, String specialist) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public long getNumberOfPatientsVisited() {
		return numberOfPatientsVisited;
	}

	public void setNumberOfPatientsVisited(long numberOfPatientsVisited) {
		this.numberOfPatientsVisited = numberOfPatientsVisited;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialist="
				+ specialist + ", numberOfPatientsVisited=" + numberOfPatientsVisited + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

}
