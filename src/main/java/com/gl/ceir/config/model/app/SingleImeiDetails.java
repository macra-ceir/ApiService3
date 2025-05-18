package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SingleImeiDetails implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	
	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date modifiedOn;

	private int processState;
	
	private Integer deviceType;
	
	private Integer multipleSimStatus;
	
	private String deviceSerialNumber;
	
	private String remark;
	
	private Integer deviceIdType;
	
	private Integer category;
	
	private Long firstImei;
	
	private Long secondImei;
	
	private Long thirdImei;
	
	private Long fourthImei;
	
	private long userId;
	
	private String userType;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Transient
	private String deviceTypeInterp;
	
	@Transient
	private String multipleSimStatusInterp;
	
	@Transient
	private String deviceIdTypeInterp;
	
	@Transient
	private String categoryInterp;
	
	@Transient
	private Integer requestType;
	
	@Column(name="sarm_id")
	private Long sarmId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "sarm_id", nullable = false,insertable = false, updatable = false)
	//@OneToOne(mappedBy = "singleImeiDetails", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
	StolenandRecoveryMgmt sARm;
	

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

	public int getProcessState() {
		return processState;
	}
	public void setProcessState(int processState) {
		this.processState = processState;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public StolenandRecoveryMgmt getsARm() {
		return sARm;
	}
	public void setsARm(StolenandRecoveryMgmt sARm) {
		this.sARm = sARm;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getMultipleSimStatus() {
		return multipleSimStatus;
	}
	public void setMultipleSimStatus(Integer multipleSimStatus) {
		this.multipleSimStatus = multipleSimStatus;
	}
	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}
	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeviceIdType() {
		return deviceIdType;
	}
	public void setDeviceIdType(Integer deviceIdType) {
		this.deviceIdType = deviceIdType;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getDeviceTypeInterp() {
		return deviceTypeInterp;
	}
	public void setDeviceTypeInterp(String deviceTypeInterp) {
		this.deviceTypeInterp = deviceTypeInterp;
	}
	public String getMultipleSimStatusInterp() {
		return multipleSimStatusInterp;
	}
	public void setMultipleSimStatusInterp(String multipleSimStatusInterp) {
		this.multipleSimStatusInterp = multipleSimStatusInterp;
	}
	public String getDeviceIdTypeInterp() {
		return deviceIdTypeInterp;
	}
	public void setDeviceIdTypeInterp(String deviceIdTypeInterp) {
		this.deviceIdTypeInterp = deviceIdTypeInterp;
	}
	public String getCategoryInterp() {
		return categoryInterp;
	}
	public void setCategoryInterp(String categoryInterp) {
		this.categoryInterp = categoryInterp;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getFirstImei() {
		return firstImei;
	}
	public void setFirstImei(Long firstImei) {
		this.firstImei = firstImei;
	}
	public Long getSecondImei() {
		return secondImei;
	}
	public void setSecondImei(Long secondImei) {
		this.secondImei = secondImei;
	}
	public Long getThirdImei() {
		return thirdImei;
	}
	public void setThirdImei(Long thirdImei) {
		this.thirdImei = thirdImei;
	}
	public Long getFourthImei() {
		return fourthImei;
	}
	public void setFourthImei(Long fourthImei) {
		this.fourthImei = fourthImei;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public Integer getRequestType() {
		return requestType;
	}
	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}
	public Long getSarmId() {
		return sarmId;
	}
	public void setSarmId(Long sarmId) {
		this.sarmId = sarmId;
	}
	
	
}
