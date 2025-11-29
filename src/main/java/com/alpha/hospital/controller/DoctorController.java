package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.services.DoctorServices;

@RestController
public class DoctorController {

	@Autowired
	private DoctorServices ds;

	// SAVE DOCTOR
	@PostMapping("/savedoctor")
	public ResponseStructure<Doctor> saveDoctor(@RequestBody Doctor d) {
		return ds.saveDoctor(d);
	}

	// UPDATE DOCTOR
	@PutMapping("/updatedoctor")
	public ResponseStructure<Doctor> updateDoctor(@RequestParam int id, @RequestParam String newname) {

		return ds.updateDoctor(id, newname);

	}

	// GET DOCTOR BY ID
	@GetMapping("/finddoctor")
	public ResponseStructure<Doctor> getDoctorById(@RequestParam int id) {
		return ds.getDoctorById(id);
	}
	
	//DELETE DOCTOR BY ID
	 @DeleteMapping("/deletedoctor")
	    public void deleteDoctor(@PathVariable int id) {
	         ds.deleteDoctor(id);
	    }

}
