package com.example.patient_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_service.model.Patient;
import com.example.patient_service.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	 PatientService patientService;
	
	public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new RuntimeException("Patient not found with id " + id);
        }
        return patient;
    }


    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully!";
    }

}
