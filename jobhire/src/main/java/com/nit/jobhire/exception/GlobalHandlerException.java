package com.nit.jobhire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

	
@ExceptionHandler(JobNotFoundException.class)
	
	public ResponseEntity<String>handleJobNotFoundException(JobNotFoundException ex){
	
	return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<String>handleValidation(MethodArgumentNotValidException ex){
		
		String message=ex.getBindingResult()
		                 .getFieldError()
		                 .getDefaultMessage();
		
		return  new  ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		
	}
}
