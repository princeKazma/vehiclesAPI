package com.daniel.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceHandler {

	// Handle all general exceptions and wrap into a Response Entity with Status Code and Exception Message
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleGlobalException(Exception exc){
		ExceptionResponse response = new ExceptionResponse(HttpStatus.CONFLICT.value(), exc.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
	}

	// Handle specific Exceptions that represent 404 Not Found
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exc){
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
}
