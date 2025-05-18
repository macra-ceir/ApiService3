package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GreylistDbHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	@JsonIgnore
	@UpdateTimestamp
	private Date modifiedOn;
	private Long imei;
	@Column(length = 15)
	private String roleType;
	private Long userId;
	@Column(length = 20)
	private String txnId;
	private String deviceNumber;
	private String deviceType;
	private String deviceAction;
	private String	 deviceStatus;
	private String DeviceLaunchDate;
	private String multipleSimStatus;
	private String  deviceId;
	private String imeiEsnMeid;

	
	private int operation;
	
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
	public Long getImei() {
		return imei;
	}
	public void setImei(Long imei) {
		this.imei = imei;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceAction() {
		return deviceAction;
	}
	public void setDeviceAction(String deviceAction) {
		this.deviceAction = deviceAction;
	}
	public String getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public String getDeviceLaunchDate() {
		return DeviceLaunchDate;
	}
	public void setDeviceLaunchDate(String deviceLaunchDate) {
		DeviceLaunchDate = deviceLaunchDate;
	}
	public String getMultipleSimStatus() {
		return multipleSimStatus;
	}
	public void setMultipleSimStatus(String multipleSimStatus) {
		this.multipleSimStatus = multipleSimStatus;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getImeiEsnMeid() {
		return imeiEsnMeid;
	}
	public void setImeiEsnMeid(String imeiEsnMeid) {
		this.imeiEsnMeid = imeiEsnMeid;
	}




}
