package com.alpha.hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.alpha.hospital.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//DOCTOR NOT FOUND 
	 @ExceptionHandler(DoctorNotFoundException.class)
	    public ResponseEntity<ResponseStructure<String>> handleDoctorNotFound(DoctorNotFoundException ex) {

	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	        rs.setMessage("Doctor Not Found");
	        rs.setData(ex.getMessage());

	        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	    }
	 
	//DOCTOR UPDATE NOT FOUND
    @ExceptionHandler(UpdateDoctorNotFoundException.class)
    public ResponseStructure<String> handleUpdateDoctorNotFound(UpdateDoctorNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Doctor Update Failed");
        rs.setData(ex.getMessage());

        return rs;
    }
    
    //DELETE DOCTOR NOT FOUND
    @ExceptionHandler(DeleteDoctorNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleDeleteDoctor(DeleteDoctorNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Doctor Not Found for Delete");
        rs.setData(ex.getMessage());

        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
    }
    
    //PATIENT NOT FOUND
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handlePatientNotFound(PatientNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Patient Not Found");
        rs.setData(ex.getMessage());

        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
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
    // DELETE PATIENT NOT FOUND EXCEPTION
    @ExceptionHandler(DeletePatientNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleDeletePatient(DeletePatientNotFoundException ex) {

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
        rs.setMessage("Patient Not Found for Delete");
        rs.setData(ex.getMessage());

        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
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
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseStructure<Map<String, String>> handleMethodArgNotValid(MethodArgumentNotValidException ex){
		Map<String,String> errormap=new HashMap<String, String>();
		List<ObjectError> objerror=ex.getAllErrors();
		for(ObjectError objError :objerror) {
			System.err.println(objError.getDefaultMessage());;
			FieldError fr =(FieldError) objError;
			System.err.println(fr.getField());;
			errormap.put(fr.getField(),objError.getDefaultMessage());
		}
		ResponseStructure<Map<String,String>> rs=new ResponseStructure<Map<String,String>>();
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("VALIDATION FAILED");
		rs.setData(errormap);
	return rs;		
	}
}
