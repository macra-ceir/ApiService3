package com.gl.ceir.config.model.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDetails {

    private String brandName;
    private String modelName;
    private String deviceType;
    private String manufacturer;
    private String marketingName;

    public DeviceDetails(String brandName, String modelName, String deviceType, String manufacturer,
            String marketingName) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.marketingName = marketingName;
    }

}