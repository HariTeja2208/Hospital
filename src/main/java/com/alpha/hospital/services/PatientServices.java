package com.alpha.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.exception.UpdatePatientNotFoundException;
import com.alpha.hospital.repository.PatientRepo;
import com.alpha.hospital.ResponseStructure;

@Service
public class PatientServices {

    @Autowired
    private PatientRepo patientRepo;

    // SAVE PATIENT
    public void savePatient(Patient patient) {
    	Patient savepatient = patientRepo.save(patient);
    }

    // UPDATE PATIENT
    public ResponseStructure<Patient> updatePatient(int id, String newName) {

 	   
	    Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new UpdatePatientNotFoundException("Patient with id " + id + " not found"));
	    existingPatient.setName(newName);
	    patientRepo.save(existingPatient);
	    ResponseStructure<Patient> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Patient updated successfully");
	    rs.setData(existingPatient);

	    return rs;
	}
}
