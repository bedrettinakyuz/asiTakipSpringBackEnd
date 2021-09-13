package com.asiTakip.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

//handle specific exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException exception, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		
		ResponseEntity responseEntity = new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
		return  responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling
	(Exception exception, WebRequest request)
	{
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		
		ResponseEntity<?> responseEntity = 
				new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		return  responseEntity;
	}
	
	

}
