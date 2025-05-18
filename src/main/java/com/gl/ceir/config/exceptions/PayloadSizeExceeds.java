package com.gl.ceir.config.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ToString
@Getter
@Setter
@ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE)
public class PayloadSizeExceeds extends RuntimeException {

    private String resourceName;
    private String message;

    public PayloadSizeExceeds(String resourceName, String message) {
        super(String.format("%s not found with %s ", resourceName, message));
        this.resourceName = resourceName;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PayloadSizeExceeds [resourceName=" + resourceName + ", message=" + message + "]";
    }
}
