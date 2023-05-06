package com.vijay.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3614218742683127135L;
	
	public EmployeeNotFoundException()
	{
		super();
		
	}
	public EmployeeNotFoundException(String message)
	{
		super(message);
		
	}
}
