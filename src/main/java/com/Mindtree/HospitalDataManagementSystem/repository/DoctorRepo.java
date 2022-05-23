package com.Mindtree.HospitalDataManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Mindtree.HospitalDataManagementSystem.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{

	@Query("select d.name from Doctor d")
	List<String> findAllDoctorNames();

	Optional<Doctor> findDoctorByName(String name);

}
