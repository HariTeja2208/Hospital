package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.services.PatientServices;

@RestController
public class PatientController {

    @Autowired
    private PatientServices ps;

    @PostMapping("/savepatient")
    public void savePatient(@RequestBody Patient P) {
        ps.savePatient(P);
       
    }
}
