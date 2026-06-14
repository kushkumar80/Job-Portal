package com.nit.user.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistException extends RuntimeException

{
	public EmailAlreadyExistException(String message) {
		
	super(message);
	}
	


}
