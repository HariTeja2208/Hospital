package com.alpha.hospital.exception;

public class UpdateDoctorNotFoundException extends RuntimeException {

    public UpdateDoctorNotFoundException() {
        super("Doctor not found for update");
    }

    public UpdateDoctorNotFoundException(String message) {
        super(message);
    }
}