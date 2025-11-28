package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.services.DoctorServices;

@RestController
public class DoctorController {

    @Autowired
    private DoctorServices ds;

    @PostMapping("/savedoctor")
    public void saveDoctor(@RequestBody Doctor d ) {
        ds.saveDoctor(d);
    }
}
