package com.alpha.hospital.exception;

public class DeleteDoctorNotFoundException extends RuntimeException {
    public DeleteDoctorNotFoundException(String message) {
        super(message);
    }
}

