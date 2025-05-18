package com.gl.ceir.config.model.app;

import com.gl.ceir.config.model.app.DeviceDetails;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
public class Result {

    private boolean isValidImei;
    private String message;
    private Map deviceDetails;
    private String complianceStatus;
    private String symbol_color;

    public Result(boolean isValidImei, String symbol_color, String complianceStatus, String message, Map deviceDetails) {
        this.isValidImei = isValidImei;
        this.symbol_color = symbol_color;
        this.complianceStatus = complianceStatus;
        this.message = message;
        this.deviceDetails = deviceDetails;
    }

    @Override
    public String toString() {
        return "Result{" + "isValidImei=" + isValidImei + ", message=" + message + ", deviceDetails=" + deviceDetails + ", complianceStatus=" + complianceStatus + ", symbol_color=" + symbol_color + '}';
    }

}
