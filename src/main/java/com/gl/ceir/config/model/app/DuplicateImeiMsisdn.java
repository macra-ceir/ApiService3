package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.ceir.config.model.constants.ImeiStatus;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class DuplicateImeiMsisdn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImeiMsisdnIdentity imeiMsisdnIdentity;

	private Long imsi;
	private String fileName;

	private Long failedRuleId;

	private String failedRuleName;

	private String mobileOperator;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	
	private boolean regulizedByUser;

	private ImeiStatus imeiStatus;

	@ManyToOne
	@JoinColumn(name = "deviceSnapShotImei")
	private DeviceSnapShot deviceSnapShot;

	public ImeiMsisdnIdentity getImeiMsisdnIdentity() {
		return imeiMsisdnIdentity;
	}

	public void setImeiMsisdnIdentity(ImeiMsisdnIdentity imeiMsisdnIdentity) {
		this.imeiMsisdnIdentity = imeiMsisdnIdentity;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMobileOperator() {
		return mobileOperator;
	}

	public void setMobileOperator(String mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	public boolean isRegulizedByUser() {
		return regulizedByUser;
	}

	public void setRegulizedByUser(boolean regulizedByUser) {
		this.regulizedByUser = regulizedByUser;
	}

	public ImeiStatus getImeiStatus() {
		return imeiStatus;
	}

	public void setImeiStatus(ImeiStatus imeiStatus) {
		this.imeiStatus = imeiStatus;
	}

	// public DeviceSnapShot getDeviceSnapShot() {
	// return deviceSnapShot;
	// }

	public void setDeviceSnapShot(DeviceSnapShot deviceSnapShot) {
		this.deviceSnapShot = deviceSnapShot;
	}

	public Long getFailedRuleId() {
		return failedRuleId;
	}

	public void setFailedRuleId(Long failedRuleId) {
		this.failedRuleId = failedRuleId;
	}

	public String getFailedRuleName() {
		return failedRuleName;
	}

	public void setFailedRuleName(String failedRuleName) {
		this.failedRuleName = failedRuleName;
	}

}
