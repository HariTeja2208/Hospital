package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.dto.Patientdto;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.services.PatientServices;

import jakarta.validation.Valid;

@RestController
public class PatientController {

    @Autowired
    private PatientServices ps;

    // SAVE PATIENT
    @PostMapping("/savepatient")
    public void savePatient(@Valid @RequestBody Patientdto pdto) {
        ps.savePatient(pdto);
    }

    // UPDATE PATIENT
    @PutMapping("/updatepatient")
    public ResponseStructure<Patient> updatePatient(@RequestParam int id, @RequestParam String newname) {

        return ps.updatePatient(id, newname);
    }
    
 // GET PATIENT BY ID
    @GetMapping("/getpatient")
    public ResponseStructure<Patient> getPatientById(@RequestParam int id) {
        return ps.getPatientById(id);
    }
    // DELETE PATIENT BY ID
    @DeleteMapping("/deletepatient")
    public void deletePatient(@PathVariable int id) {
         ps.deletePatient(id);
    }

}
