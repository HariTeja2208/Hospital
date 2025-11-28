package com.alpha.hospital.exception;

public class UpdatePatientNotFoundException extends RuntimeException {

    public UpdatePatientNotFoundException() {
        super("Patient not found for update");
    }

    public UpdatePatientNotFoundException(String message) {
        super(message);
    }
}