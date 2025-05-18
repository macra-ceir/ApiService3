package com.gl.ceir.config.model.app;

import lombok.Getter;
import lombok.Setter;



/// response might has some annotation for default   check_imei_Response
@Getter
@Setter
public class CheckImeiResponse  {

    private String statusCode;
    private String statusMessage;
    private String language;
    private Result result;

    public CheckImeiResponse(String statusCode, String statusMessage, String language, Result result) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.language = language;
        this.result = result;
    }

    @Override
    public String toString() {
        return "CheckImeiResponse{" + "statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", language=" + language + ", result=" + result + '}';
    }

    

}



