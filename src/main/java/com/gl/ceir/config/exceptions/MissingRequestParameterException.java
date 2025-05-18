/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MissingRequestParameterException extends RuntimeException {

    private String resourceName;
    private String message;

    public MissingRequestParameterException(String resourceName, String message) {
        super(String.format("%s not found with %s ", resourceName, message));
        this.resourceName = resourceName;
        this.message = message;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "UnprocessableEntityException [resourceName=" + resourceName + ", message=" + message + "]";
    }

}
