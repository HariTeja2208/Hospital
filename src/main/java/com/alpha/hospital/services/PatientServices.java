package com.alpha.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.repository.PatientRepo;

@Service
public class PatientServices {

    @Autowired
    private PatientRepo pr;

    public void savePatient(Patient P) {
        pr.save(P);
    }
}
