package com.Mindtree.HospitalDataManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Mindtree.HospitalDataManagementSystem.model.Doctor;
import com.Mindtree.HospitalDataManagementSystem.model.Patient;
import com.Mindtree.HospitalDataManagementSystem.repository.DoctorRepo;
import com.Mindtree.HospitalDataManagementSystem.repository.PatientRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiService {
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	public ResponseEntity<Doctor> findDoctorByName(String name) {
		Optional<Doctor> doctor=doctorRepo.findDoctorByName(name);
		if(doctor.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor with "+name+" is not found");
		}
		return new ResponseEntity<Doctor>(doctor.get(),HttpStatus.OK);
	}
	
	public ResponseEntity<List<String>> findAllDoctorNames(){
		List<String> doctorNames= doctorRepo.findAllDoctorNames();
		return new ResponseEntity<List<String>>(doctorNames,HttpStatus.OK);
	}
	
	public ResponseEntity<Patient> findPatientById(long id){
		Optional<Patient> patient = patientRepo.findById(id);
		if(patient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No such patient there in the database");
		}
		return new ResponseEntity<Patient>(patient.get(),HttpStatus.OK);
	}
	
	public ResponseEntity<Doctor> createDocter(Doctor doctor) {
		Doctor newDoctor = doctorRepo.save(doctor);
		return new ResponseEntity<Doctor>(newDoctor,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Patient> createPatient(Patient patient){
		String doctorName=patient.getVisitedDoctor();
		Optional<Doctor> doctor= doctorRepo.findDoctorByName(doctorName);
		if(doctor.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor with "+doctorName+" is not found");
		}
		Doctor doc = doctor.get();
		doc.setNumberOfPatientsVisited(doc.getNumberOfPatientsVisited()+1);
		doctorRepo.save(doc);
		Patient newPatient =patientRepo.save(patient);
		return new ResponseEntity<Patient>(newPatient,HttpStatus.CREATED);
	}
}
