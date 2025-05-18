package com.gl.ceir.config.model.app;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomImeiCheckResponse {


    private String imei;
    private String serialNumber;
    private String statusCode;
    private String statusMessage;

    private String deviceType;
    private String deviceBrand;
    private String modelName;
    private String marketingName;
    private String manufacturer;


    public CustomImeiCheckResponse(String imei, String serialNumber, String statusCode, String statusMessage,
                                   String deviceType, String deviceBrand, String modelName,String marketingName ,String manufacturer) {
        this.imei = imei;
        this.serialNumber = serialNumber;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.deviceType = deviceType;
        this.deviceBrand = deviceBrand;
        this.modelName = modelName;
        this. marketingName=marketingName;
        this.manufacturer = manufacturer;

    }
    @Override
    public String toString() {
        return "{" +
                "imei='" + imei + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceBrand='" + deviceBrand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", marketingName='" + marketingName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}



