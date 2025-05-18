/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.model.app;

/**
 *
 * @author user
 */
public class CheckImeiValuesEntity {
     
     String user_type;  String feature ; String imei; Long imei_type ;

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

  
    public Long getImei_type() {
        return imei_type;
    }

    public void setImei_type(Long imei_type) {
        this.imei_type = imei_type;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
            
    
    
}
