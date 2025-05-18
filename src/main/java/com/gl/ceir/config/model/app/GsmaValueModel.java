package com.gl.ceir.config.model.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "gsma_valid_tac")
@Entity
public class GsmaValueModel implements Serializable {

     private static final long serialVersionUID = 1L;

     @Id
     private int deviceId;
     private String bandName;
     private String modelName;
     private String equipmentType;
     private String operatingSystem;

     @Transient
     private String imei;
     @Transient
     private String imsi;
     @Transient
     private String msisdn;
     @Transient
     private String identifierType;

     @Transient
     private int FOREGIN_RULE;
     @Transient
     private String MOBILE_OPERATOR;
     @Transient
     private String PERIOD;
     @Transient
     private String CREATE_FILENAME;
     @Transient
     private String UPDATE_FILENAME;
     @Transient
     private String SYSTEM_TYPE;
     @Transient
     private String FAILED_RULE_ID;
     @Transient
     private String FAILED_RULE_NAME;
     @Transient
     private String TAC;
     @Transient
     private String ACTION;
     @Transient
     private String FAILED_RULE_DATE;
     @Transient
     private String FEATURE_NAME;
     @Transient
     private String RECORD_TIME;
     @Transient
     private String RECORD_TYPE;

     public int getFOREGIN_RULE() {
          return FOREGIN_RULE;
     }

     public void setFOREGIN_RULE(int FOREGIN_RULE) {
          this.FOREGIN_RULE = FOREGIN_RULE;
     }

     public String getMOBILE_OPERATOR() {
          return MOBILE_OPERATOR;
     }

     public void setMOBILE_OPERATOR(String MOBILE_OPERATOR) {
          this.MOBILE_OPERATOR = MOBILE_OPERATOR;
     }

     public String getPERIOD() {
          return PERIOD;
     }

     public void setPERIOD(String PERIOD) {
          this.PERIOD = PERIOD;
     }

     public String getCREATE_FILENAME() {
          return CREATE_FILENAME;
     }

     public void setCREATE_FILENAME(String CREATE_FILENAME) {
          this.CREATE_FILENAME = CREATE_FILENAME;
     }

     public String getUPDATE_FILENAME() {
          return UPDATE_FILENAME;
     }

     public void setUPDATE_FILENAME(String UPDATE_FILENAME) {
          this.UPDATE_FILENAME = UPDATE_FILENAME;
     }

     public String getSYSTEM_TYPE() {
          return SYSTEM_TYPE;
     }

     public void setSYSTEM_TYPE(String SYSTEM_TYPE) {
          this.SYSTEM_TYPE = SYSTEM_TYPE;
     }

     public String getFAILED_RULE_ID() {
          return FAILED_RULE_ID;
     }

     public void setFAILED_RULE_ID(String FAILED_RULE_ID) {
          this.FAILED_RULE_ID = FAILED_RULE_ID;
     }

     public String getFAILED_RULE_NAME() {
          return FAILED_RULE_NAME;
     }

     public void setFAILED_RULE_NAME(String FAILED_RULE_NAME) {
          this.FAILED_RULE_NAME = FAILED_RULE_NAME;
     }

     public String getTAC() {
          return TAC;
     }

     public void setTAC(String TAC) {
          this.TAC = TAC;
     }

     public String getACTION() {
          return ACTION;
     }

     public void setACTION(String ACTION) {
          this.ACTION = ACTION;
     }

     public String getFAILED_RULE_DATE() {
          return FAILED_RULE_DATE;
     }

     public void setFAILED_RULE_DATE(String FAILED_RULE_DATE) {
          this.FAILED_RULE_DATE = FAILED_RULE_DATE;
     }

     public String getFEATURE_NAME() {
          return FEATURE_NAME;
     }

     public void setFEATURE_NAME(String FEATURE_NAME) {
          this.FEATURE_NAME = FEATURE_NAME;
     }

     public String getRECORD_TIME() {
          return RECORD_TIME;
     }

     public void setRECORD_TIME(String RECORD_TIME) {
          this.RECORD_TIME = RECORD_TIME;
     }

     public String getRECORD_TYPE() {
          return RECORD_TYPE;
     }

     public void setRECORD_TYPE(String RECORD_TYPE) {
          this.RECORD_TYPE = RECORD_TYPE;
     }

     
     
     
     public int getDeviceId() {
          return deviceId;
     }

     public void setDeviceId(int deviceId) {
          this.deviceId = deviceId;
     }

     public String getBandName() {
          return bandName;
     }

     public void setBandName(String bandName) {
          this.bandName = bandName;
     }

     public String getModelName() {
          return modelName;
     }

     public void setModelName(String modelName) {
          this.modelName = modelName;
     }

     public String getEquipmentType() {
          return equipmentType;
     }

     public void setEquipmentType(String equipmentType) {
          this.equipmentType = equipmentType;
     }

     public String getOperatingSystem() {
          return operatingSystem;
     }

     public void setOperatingSystem(String operatingSystem) {
          this.operatingSystem = operatingSystem;
     }

     public String getIdentifierType() {
          return identifierType;
     }

     public void setIdentifierType(String identifierType) {
          this.identifierType = identifierType;
     }

     public String getImei() {
          return imei;
     }

     public void setImei(String imei) {
          this.imei = imei;
     }

     public String getImsi() {
          return imsi;
     }

     public void setImsi(String imsi) {
          this.imsi = imsi;
     }

     public String getMsisdn() {
          return msisdn;
     }

     public void setMsisdn(String msisdn) {
          this.msisdn = msisdn;
     }

}
