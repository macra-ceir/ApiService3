
package com.gl.ceir.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnAuthorizationException extends RuntimeException {

    private String resourceName;
    private String message;

    public UnAuthorizationException(String resourceName, String message) {
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
        return "UnAuthorizationException [resourceName=" + resourceName + ", message=" + message + "]";
    }

}
