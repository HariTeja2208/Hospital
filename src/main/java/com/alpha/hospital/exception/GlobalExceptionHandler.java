package com.alpha.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.alpha.hospital.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UpdateDoctorNotFoundException.class)
    public ResponseStructure<String> handleUpdateDoctorNotFound(UpdateDoctorNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Doctor Update Failed");
        rs.setData(ex.getMessage());

        return rs;
    }

    // PATIENT UPDATE NOT FOUND
    @ExceptionHandler(UpdatePatientNotFoundException.class)
    public ResponseStructure<String> handleUpdatePatientNotFound(UpdatePatientNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Patient Update Failed");
        rs.setData(ex.getMessage());

        return rs;
    }

    // Global / Any Other Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> handleGeneralException(Exception ex) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        structure.setMessage("Something Went Wrong");
        structure.setData(ex.getMessage());

        return new ResponseEntity<>(structure, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //
    
}
