package com.Mindtree.HospitalDataManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mindtree.HospitalDataManagementSystem.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
