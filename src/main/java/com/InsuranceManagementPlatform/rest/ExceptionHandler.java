package com.InsuranceManagementPlatform.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    // add exception handling code
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exe) {


        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return an responseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
    // Add an exception handler

    @org.springframework.web.bind.annotation.ExceptionHandler

    public ResponseEntity<ErrorResponse> handleException(Exception exe) {


        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return an responseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
