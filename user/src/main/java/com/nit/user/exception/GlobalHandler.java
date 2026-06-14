package com.nit.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalHandler {
	
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	
	public ResponseEntity<String> handleEmailExistException(EmailAlreadyExistException  ex){
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	
	public ResponseEntity<String>handleUserNotFoundException(UserNotFoundException ex){
		return new ResponseEntity<>
		(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	
	public ResponseEntity<String>handleInvalidCredentialsException(InvalidCredentialsException ex)
	
	{
		return new  ResponseEntity<>
		(ex.getMessage(),HttpStatus.UNAUTHORIZED);
	}
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(
	            MethodArgumentNotValidException ex) {

	        String errorMessage = ex.getBindingResult()
	                .getFieldError()
	                .getDefaultMessage();

	        return new ResponseEntity<>(
	                errorMessage,
	                HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGlobalException(
	            Exception ex) {

	        return new ResponseEntity<>(
	                ex.getMessage(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	

}
