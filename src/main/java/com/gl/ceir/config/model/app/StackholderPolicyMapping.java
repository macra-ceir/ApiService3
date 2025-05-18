package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StackholderPolicyMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createdOn;
	private Date modifiedOn;

	private String listType;
	private int time;
	private String units;
	private String dumpType;
	private int deviceMaxValue;
	private int graceTimePeriod;
	private String gracePeriodUnit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getDumpType() {
		return dumpType;
	}
	public void setDumpType(String dumpType) {
		this.dumpType = dumpType;
	}
	public int getDeviceMaxValue() {
		return deviceMaxValue;
	}
	public void setDeviceMaxValue(int deviceMaxValue) {
		this.deviceMaxValue = deviceMaxValue;
	}
	public int getGraceTimePeriod() {
		return graceTimePeriod;
	}
	public void setGraceTimePeriod(int graceTimePeriod) {
		this.graceTimePeriod = graceTimePeriod;
	}
	public String getGracePeriodUnit() {
		return gracePeriodUnit;
	}
	public void setGracePeriodUnit(String gracePeriodUnit) {
		this.gracePeriodUnit = gracePeriodUnit;
	}
	
	
	
}
