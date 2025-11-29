package com.alpha.hospital.exception;

public class DeletePatientNotFoundException extends RuntimeException {
    public DeletePatientNotFoundException(String message) {
        super(message);
    }
}
