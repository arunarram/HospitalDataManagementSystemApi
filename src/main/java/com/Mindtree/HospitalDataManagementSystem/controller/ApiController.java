package com.Mindtree.HospitalDataManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mindtree.HospitalDataManagementSystem.model.Doctor;
import com.Mindtree.HospitalDataManagementSystem.model.Patient;
import com.Mindtree.HospitalDataManagementSystem.service.ApiService;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
	@Autowired
	ApiService service;

	@GetMapping(value = "/doctorNames")
	public ResponseEntity<List<String>> findAllDoctorNames() {
		return service.findAllDoctorNames();
	}

	@GetMapping(value = "/doctor/{name}")
	public ResponseEntity<Doctor> findDoctorByName(@PathVariable String name) {
		return service.findDoctorByName(name);
	}

	@GetMapping(value = "/patient/{id}")
	public ResponseEntity<Patient> findPatientById(@PathVariable long id) {
		return service.findPatientById(id);
	}

	@PostMapping(value = "/doctor")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
		return service.createDocter(doctor);
	}

	@PostMapping(value = "/patient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		return service.createPatient(patient);
	}

}
