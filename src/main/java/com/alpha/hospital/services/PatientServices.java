package com.alpha.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.exception.DeletePatientNotFoundException;
import com.alpha.hospital.exception.UpdatePatientNotFoundException;
import com.alpha.hospital.repository.PatientRepo;
import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.dto.Patientdto;

@Service
public class PatientServices {

    @Autowired
    private PatientRepo patientRepo;

    // SAVE PATIENT
    public void savePatient(Patientdto pdto) {
    	Patient p = new Patient();
    	p.setName(pdto.getName());
    	p.setAge(pdto.getAge());
    	p.setDisease(pdto.getDisease());
    	p.setGender(pdto.getGender());
    	Patient savePatient= patientRepo.save(p);
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
    
 // FIND PATIENT BY ID
    public ResponseStructure<Patient> getPatientById(int id) {

        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new UpdatePatientNotFoundException("Patient with id " + id + " not found"));

        ResponseStructure<Patient> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Patient fetched successfully");
        rs.setData(patient);

        return rs;
    }
    public ResponseStructure<String> deletePatient(int id) {

        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new DeletePatientNotFoundException("Patient not found with ID: " + id));

        patientRepo.delete(patient);

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Patient deleted successfully");
        rs.setData("Deleted patient with ID: " + id);

        return rs;
    }

}
