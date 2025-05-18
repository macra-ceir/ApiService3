/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.ceir.config.model.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "active_imei_with_different_msisdn")
@Entity
public class DuplicateValueModel implements Serializable {

     @Id
     private String imei;
     private String msisdn;
     private String imsi;

     public String getImei() {
          return imei;
     }

     public void setImei(String imei) {
          this.imei = imei;
     }

     public String getMsisdn() {
          return msisdn;
     }

     public void setMsisdn(String msisdn) {
          this.msisdn = msisdn;
     }

     public String getImsi() {
          return imsi;
     }

     public void setImsi(String imsi) {
          this.imsi = imsi;
     }

     @Override
     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("DuplicateValueModel{imei=").append(imei);
          sb.append(", msisdn=").append(msisdn);
          sb.append(", imsi=").append(imsi);
          sb.append('}');
          return sb.toString();
     }
  
     
     
     


     
     
     
     
}

    
