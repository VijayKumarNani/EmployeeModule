package com.vijay.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vijay.exception.EmployeeNotFoundException;

//If any exception occurs in controller class, comes here
//It is used to write a common catch block code(Re usable)
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleException(EmployeeNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
