package com.alpha.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.exception.UpdateDoctorNotFoundException;
import com.alpha.hospital.repository.DoctorRepo;
import com.alpha.hospital.ResponseStructure;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepo doctorRepo;

    // SAVE
    public ResponseStructure<Doctor> saveDoctor(Doctor doctor) {

        Doctor savedDoctor = doctorRepo.save(doctor);

        ResponseStructure<Doctor> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.CREATED.value());
        rs.setMessage("Doctor saved successfully");
        rs.setData(savedDoctor);

        return rs;
    }

    // UPDATE
    public ResponseStructure<Doctor> updateDoctor(int id, String newName) {

	    Doctor existingDoctor = doctorRepo.findById(id).orElseThrow(() -> new UpdateDoctorNotFoundException("Doctor with id " + id + " not found"));
	    existingDoctor.setName(newName);
	    doctorRepo.save(existingDoctor);
	    ResponseStructure<Doctor> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Doctor updated successfully");
	    rs.setData(existingDoctor);

	    return rs;
    }
    
    
}
