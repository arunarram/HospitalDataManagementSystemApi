package com.Mindtree.HospitalDataManagementSystem.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Mindtree.HospitalDataManagementSystem.model.Doctor;
import com.Mindtree.HospitalDataManagementSystem.model.Gender;
import com.Mindtree.HospitalDataManagementSystem.model.Patient;
import com.Mindtree.HospitalDataManagementSystem.service.ApiService;

@ExtendWith(MockitoExtension.class)
class ApiControllerTest {

	@InjectMocks
	ApiController apiController;

	@Mock
	ApiService apiService;

	@Test
	void testFindAllDoctorNames() {
		List<String> doctorNames = new ArrayList<>();
		doctorNames.add("Arun Kumar");
		doctorNames.add("Krishna");
		doctorNames.add("Subhash");
		when(apiService.findAllDoctorNames()).thenReturn(new ResponseEntity<List<String>>(doctorNames, HttpStatus.OK));

		ResponseEntity<List<String>> result = apiController.findAllDoctorNames();

		assertThat(result.getBody().get(0)).isEqualTo(doctorNames.get(0));
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testFindDoctorByName() {
		Doctor doctor = new Doctor("Arun Kumar", 30, Gender.Male, "ENT");
		when(apiService.findDoctorByName("Arun Kumar")).thenReturn(new ResponseEntity<Doctor>(doctor, HttpStatus.OK));
		
		ResponseEntity<Doctor> result = apiController.findDoctorByName("Arun Kumar");

		assertThat(result.getBody()).isEqualTo(doctor);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testFindPatientById() {
		Patient patient = new Patient("Raju","Arun Kumar",new Date(2022-05-21),"Drink water Daily");
		when(apiService.findPatientById(1)).thenReturn(new ResponseEntity<Patient>(patient, HttpStatus.OK));
		
		ResponseEntity<Patient> result = apiController.findPatientById(1);

		assertThat(result.getBody()).isEqualTo(patient);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor("Arun Kumar", 30, Gender.Male, "ENT");
		when(apiService.createDocter(doctor)).thenReturn(new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED));
		
		ResponseEntity<Doctor> result = apiController.createDoctor(doctor);

		assertThat(result.getBody()).isEqualTo(doctor);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	void testCreatePatient() {
		Patient patient = new Patient("Raju","Arun Kumar",new Date(2022-05-21),"Drink water Daily");
		when(apiService.createPatient(patient)).thenReturn(new ResponseEntity<Patient>(patient, HttpStatus.CREATED));
		
		ResponseEntity<Patient> result = apiController.createPatient(patient);

		assertThat(result.getBody()).isEqualTo(patient);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

}
