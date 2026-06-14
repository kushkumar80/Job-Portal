package com.nit.applicationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalHandlerException {
	
	@ExceptionHandler(ApplicationNotFoundException.class)
	
	public ResponseEntity<String>handleApplicationNotFound(ApplicationNotFoundException ex){
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
