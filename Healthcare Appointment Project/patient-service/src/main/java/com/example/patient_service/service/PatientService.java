package com.example.patient_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	 public PatientService(PatientRepository patientRepository) {
	        this.patientRepository = patientRepository;
	    }
	 
	 

	    public Patient savePatient(Patient patient) {
	        return patientRepository.save(patient);
	    }

	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	    public Patient getPatientById(Long id) {
	        return patientRepository.findById(id).orElse(null);
	    }


	    public void deletePatient(Long id) {
	        patientRepository.deleteById(id);
	    }
}
