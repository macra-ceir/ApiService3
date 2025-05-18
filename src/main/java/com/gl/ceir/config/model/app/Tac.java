package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

//import io.swagger.annotations.ApiModel;

//@ApiModel
@Entity
public class Tac implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String marketingName;

	private String manufacturerOrApplicant;

	private String band;
	private String bandName;
	private String modelName;
	private String operatingSystem;
	private String nfc;
	private String bluetooth;
	private String wlan;
	private String deviceType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getManufacturerOrApplicant() {
		return manufacturerOrApplicant;
	}

	public void setManufacturerOrApplicant(String manufacturerOrApplicant) {
		this.manufacturerOrApplicant = manufacturerOrApplicant;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
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

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getNfc() {
		return nfc;
	}

	public void setNfc(String nfc) {
		this.nfc = nfc;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getWlan() {
		return wlan;
	}

	public void setWlan(String wlan) {
		this.wlan = wlan;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public String toString() {
		return "Tac [id=" + id + ", marketingName=" + marketingName + ", manufacturerOrApplicant="
				+ manufacturerOrApplicant + ", band=" + band + ", bandName=" + bandName + ", modelName=" + modelName
				+ ", operatingSystem=" + operatingSystem + ", nfc=" + nfc + ", bluetooth=" + bluetooth + ", wlan="
				+ wlan + ", deviceType=" + deviceType + "]";
	}

}
