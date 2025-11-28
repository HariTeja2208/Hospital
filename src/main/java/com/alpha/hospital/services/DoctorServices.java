package com.alpha.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.repository.DoctorRepo;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepo dr;

    public void saveDoctor(Doctor D) {
        dr.save(D);
    }
}
