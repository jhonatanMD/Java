package com.api.carrito.ws.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerError {
	
	

	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ErrorHandlerNotFound.class)
	public ResponseEntity<ErrorResponse> mapException(ErrorHandlerNotFound error){
	
		ErrorResponse responseError = new ErrorResponse(300, error.getMessage(), 
				HttpStatus.NOT_FOUND.value(), new Date());
		
		 	return new ResponseEntity<ErrorResponse>(responseError,HttpStatus.NOT_FOUND);
	}

	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ErrorHandler.class)
	public ResponseEntity<ErrorResponse> mapException2(ErrorHandler error){
	
		ErrorResponse responseError = new ErrorResponse(301, error.getMessage(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
		
		return new ResponseEntity<ErrorResponse>(responseError,HttpStatus.NOT_FOUND);
	}
	
	
}
