package com.gl.ceir.config.model.constants;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter //Lombok annotation
@Setter
@Builder
@Entity

public class CustomCheckImeiRequest {

    String imei;
    String serialNumber;


    @Override
    public String toString() {
        return "{" +
                "imei='" + imei + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
