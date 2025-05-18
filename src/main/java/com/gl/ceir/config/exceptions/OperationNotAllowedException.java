package com.gl.ceir.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OperationNotAllowedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String operation;
	private String tableName;
	private String message;

	public OperationNotAllowedException(String operation, String tableName) {
		this.operation = operation;
		this.tableName = tableName;
		this.message = String.format("%s next state not allowed for %s ", operation, tableName);
	}

	public String getMessage() {
		return message;
	}
}
