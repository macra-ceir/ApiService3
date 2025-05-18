package com.gl.ceir.config.exceptions.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gl.ceir.config.dto.ApiResponse;
import com.gl.ceir.config.exceptions.FileStorageException;
import com.gl.ceir.config.exceptions.MyFileNotFoundException;
import com.gl.ceir.config.exceptions.ResourceNotFoundException;
import com.gl.ceir.config.exceptions.ResourceServicesException;

// @ControllerAdvice
public class AllExceptions {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
		return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "FAIL", exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ResourceServicesException.class)
	public ResponseEntity<Object> exception(ResourceServicesException exception) {
		return new ResponseEntity<>(
				new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "EXCEPTION", exception.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = MyFileNotFoundException.class)
	public ResponseEntity<Object> exception(MyFileNotFoundException exception) {
		return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "FAIL", exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FileStorageException.class)
	public ResponseEntity<Object> exception(FileStorageException exception) {
		return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "FAIL", exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
        
        
        
        
        
        
        
}
