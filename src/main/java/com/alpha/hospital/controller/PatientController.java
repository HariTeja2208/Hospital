package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.services.PatientServices;

@RestController
public class PatientController {

    @Autowired
    private PatientServices ps;

    // SAVE PATIENT
    @PostMapping("/savepatient")
    public ResponseStructure<Patient> savePatient(@RequestBody Patient patient) {
        return ps.savePatient(patient);
    }

    // UPDATE PATIENT
    @PutMapping("/updatepatient")
    public ResponseStructure<Patient> updatePatient(@RequestParam int id, @RequestParam String newname) {

        return ps.updatePatient(id, newname);
    }
}
