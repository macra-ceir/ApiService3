package com.gl.ceir.config.model.app;

//package com.gl.ceir.config.model;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//public class DeviceDb  implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@JsonIgnore
//	@CreationTimestamp
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
//	private Date createdOn;
//
//	@JsonIgnore
//	@UpdateTimestamp
//	private Date modifiedOn;
//
//	private String manufatureDate;
//	private String deviceType;
//	private String deviceIdType;
//	private String multipleSimStatus;
//	private String snOfDevice;
//	private String imeiEsnMeid;
//	private LocalDateTime DeviceLaunchDate;
//	private String deviceStatus;
//	private String deviceAction;
//
//	private Long importerUserId;
//	private Long distributerUserId;
//	private Long retailerUserId;
//	private Long customUserId;
//	private Long endUserUserId;
//
//	private String importerTxnId;
//	private String distributerTxnId;
//	private String retalierTxnId;        
//	private String customTxnId;
//	private String endUserTxnId;   
//
//	private LocalDateTime importerDate;
//	private LocalDateTime distributerDate;
//	private LocalDateTime retailerDate;
//	private LocalDateTime customDate;
//	private LocalDateTime endUserDate;
//
//	private Integer importerDeviceStatus;
//	private Integer distributerDeviceStatus;
//	private Integer retailerDeviceStatus;
//	private Integer customDeviceStatus;
//	private Integer endUserDeviceStatus;
//
//	private Integer previousImporterDeviceStatus;
//	private Integer previousDistributerDeviceStatus;
//	private Integer previousRetailerDeviceStatus;
//	private Integer previousCustomDeviceStatus;
//	private Integer previousEndUserDeviceStatus;
//
//	private String endUserCountry;
//	private Integer period;
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Date getCreatedOn() {
//		return createdOn;
//	}
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}
//	public Date getModifiedOn() {
//		return modifiedOn;
//	}
//	public void setModifiedOn(Date modifiedOn) {
//		this.modifiedOn = modifiedOn;
//	}
//	public String getDeviceType() {
//		return deviceType;
//	}
//	public void setDeviceType(String deviceType) {
//		this.deviceType = deviceType;
//	}
//
//	public Long getImporterUserId() {
//		return importerUserId;
//	}
//
//	public void setImporterUserId(Long importerUserId) {
//		this.importerUserId = importerUserId;
//	}
//	public Long getDistributerUserId() {
//		return distributerUserId;
//	}
//	public void setDistributerUserId(Long distributerUserId) {
//		this.distributerUserId = distributerUserId;
//	}
//	public Long getRetailerUserId() {
//		return retailerUserId;
//	}
//	public void setRetailerUserId(Long retailerUserId) {
//		this.retailerUserId = retailerUserId;
//	}
//	public String getImporterTxnId() {
//		return importerTxnId;
//	}
//	public void setImporterTxnId(String impoterTxnId) {
//		this.importerTxnId = impoterTxnId;
//	}
//	public String getDistributerTxnId() {
//		return distributerTxnId;
//	}
//	public void setDistributerTxnId(String distributerTxnId) {
//		this.distributerTxnId = distributerTxnId;
//	}
//	public String getRetalierTxnId() {
//		return retalierTxnId;
//	}
//	public void setRetalierTxnId(String retalierTxnId) {
//		this.retalierTxnId = retalierTxnId;
//	}
//	public String getDeviceStatus() {
//		return deviceStatus;
//	}
//	public void setDeviceStatus(String deviceStatus) {
//		this.deviceStatus = deviceStatus;
//	}
//	public LocalDateTime getDeviceLaunchDate() {
//		return DeviceLaunchDate;
//	}
//	public void setDeviceLaunchDate(LocalDateTime deviceLaunchDate) {
//		DeviceLaunchDate = deviceLaunchDate;
//	}
//	public String getMultipleSimStatus() {
//		return multipleSimStatus;
//	}
//	public void setMultipleSimStatus(String multipleSimStatus) {
//		this.multipleSimStatus = multipleSimStatus;
//	}
//	public String getImeiEsnMeid() {
//		return imeiEsnMeid;
//	}
//	public void setImeiEsnMeid(String imeiEsnMeid) {
//		this.imeiEsnMeid = imeiEsnMeid;
//	}
//	public String getDeviceAction() {
//		return deviceAction;
//	}
//	public void setDeviceAction(String deviceAction) {
//		this.deviceAction = deviceAction;
//	}
//	public String getManufatureDate() {
//		return manufatureDate;
//	}
//	public void setManufatureDate(String manufatureDate) {
//		this.manufatureDate = manufatureDate;
//	}
//	public LocalDateTime getImporterDate() {
//		return importerDate;
//	}
//	public void setImporterDate(LocalDateTime importerDate) {
//		this.importerDate = importerDate;
//	}
//	public LocalDateTime getDistributerDate() {
//		return distributerDate;
//	}
//	public void setDistributerDate(LocalDateTime distributerDate) {
//		this.distributerDate = distributerDate;
//	}
//	public LocalDateTime getRetailerDate() {
//		return retailerDate;
//	}
//	public void setRetailerDate(LocalDateTime retailerDate) {
//		this.retailerDate = retailerDate;
//	}
//	public Integer getImporterDeviceStatus() {
//		return importerDeviceStatus;
//	}
//	public void setImporterDeviceStatus(Integer importerDeviceStatus) {
//		this.importerDeviceStatus = importerDeviceStatus;
//	}
//	public Integer getDistributerDeviceStatus() {
//		return distributerDeviceStatus;
//	}
//	public void setDistributerDeviceStatus(Integer distributerDeviceStatus) {
//		this.distributerDeviceStatus = distributerDeviceStatus;
//	}
//	public Integer getRetailerDeviceStatus() {
//		return retailerDeviceStatus;
//	}
//	public void setRetailerDeviceStatus(Integer retailerDeviceStatus) {
//		this.retailerDeviceStatus = retailerDeviceStatus;
//	}
//	public Integer getPreviousImporterDeviceStatus() {
//		return previousImporterDeviceStatus;
//	}
//	public void setPreviousImporterDeviceStatus(Integer previousImporterDeviceStatus) {
//		this.previousImporterDeviceStatus = previousImporterDeviceStatus;
//	}
//	public Integer getPreviousDistributerDeviceStatus() {
//		return previousDistributerDeviceStatus;
//	}
//	public void setPreviousDistributerDeviceStatus(Integer previousDistributerDeviceStatus) {
//		this.previousDistributerDeviceStatus = previousDistributerDeviceStatus;
//	}
//	public Integer getPreviousRetailerDeviceStatus() {
//		return previousRetailerDeviceStatus;
//	}
//	public void setPreviousRetailerDeviceStatus(Integer previousRetailerDeviceStatus) {
//		this.previousRetailerDeviceStatus = previousRetailerDeviceStatus;
//	}
//	public Long getCustomUserId() {
//		return customUserId;
//	}
//	public void setCustomUserId(Long customUserId) {
//		this.customUserId = customUserId;
//	}
//	public Long getEndUserUserId() {
//		return endUserUserId;
//	}
//	public void setEndUserUserId(Long endUserUserId) {
//		this.endUserUserId = endUserUserId;
//	}
//	public String getCustomTxnId() {
//		return customTxnId;
//	}
//	public void setCustomTxnId(String customTxnId) {
//		this.customTxnId = customTxnId;
//	}
//	public String getEndUserTxnId() {
//		return endUserTxnId;
//	}
//	public void setEndUserTxnId(String endUserTxnId) {
//		this.endUserTxnId = endUserTxnId;
//	}
//	public LocalDateTime getCustomDate() {
//		return customDate;
//	}
//	public void setCustomDate(LocalDateTime customDate) {
//		this.customDate = customDate;
//	}
//	public LocalDateTime getEndUserDate() {
//		return endUserDate;
//	}
//	public void setEndUserDate(LocalDateTime endUserDate) {
//		this.endUserDate = endUserDate;
//	}
//	public Integer getCustomDeviceStatus() {
//		return customDeviceStatus;
//	}
//	public void setCustomDeviceStatus(Integer customDeviceStatus) {
//		this.customDeviceStatus = customDeviceStatus;
//	}
//	public Integer getEndUserDeviceStatus() {
//		return endUserDeviceStatus;
//	}
//	public void setEndUserDeviceStatus(Integer endUserDeviceStatus) {
//		this.endUserDeviceStatus = endUserDeviceStatus;
//	}
//	public Integer getPreviousCustomDeviceStatus() {
//		return previousCustomDeviceStatus;
//	}
//	public void setPreviousCustomDeviceStatus(Integer previousCustomDeviceStatus) {
//		this.previousCustomDeviceStatus = previousCustomDeviceStatus;
//	}
//	public Integer getPreviousEndUserDeviceStatus() {
//		return previousEndUserDeviceStatus;
//	}
//	public void setPreviousEndUserDeviceStatus(Integer previousEndUserDeviceStatus) {
//		this.previousEndUserDeviceStatus = previousEndUserDeviceStatus;
//	}
//	public String getEndUserCountry() {
//		return endUserCountry;
//	}
//	public void setEndUserCountry(String endUserCountry) {
//		this.endUserCountry = endUserCountry;
//	}
//	public String getDeviceIdType() {
//		return deviceIdType;
//	}
//	public void setDeviceIdType(String deviceIdType) {
//		this.deviceIdType = deviceIdType;
//	}
//	public String getSnOfDevice() {
//		return snOfDevice;
//	}
//	public void setSnOfDevice(String snOfDevice) {
//		this.snOfDevice = snOfDevice;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	public Integer getPeriod() {
//		return period;
//	}
//	public void setPeriod(Integer period) {
//		this.period = period;
//	}
//	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("DeviceDb [id=");
//		builder.append(id);
//		builder.append(", createdOn=");
//		builder.append(createdOn);
//		builder.append(", modifiedOn=");
//		builder.append(modifiedOn);
//		builder.append(", manufatureDate=");
//		builder.append(manufatureDate);
//		builder.append(", deviceType=");
//		builder.append(deviceType);
//		builder.append(", deviceIdType=");
//		builder.append(deviceIdType);
//		builder.append(", multipleSimStatus=");
//		builder.append(multipleSimStatus);
//		builder.append(", snOfDevice=");
//		builder.append(snOfDevice);
//		builder.append(", imeiEsnMeid=");
//		builder.append(imeiEsnMeid);
//		builder.append(", DeviceLaunchDate=");
//		builder.append(DeviceLaunchDate);
//		builder.append(", deviceStatus=");
//		builder.append(deviceStatus);
//		builder.append(", deviceAction=");
//		builder.append(deviceAction);
//		builder.append(", importerUserId=");
//		builder.append(importerUserId);
//		builder.append(", distributerUserId=");
//		builder.append(distributerUserId);
//		builder.append(", retailerUserId=");
//		builder.append(retailerUserId);
//		builder.append(", customUserId=");
//		builder.append(customUserId);
//		builder.append(", endUserUserId=");
//		builder.append(endUserUserId);
//		builder.append(", importerTxnId=");
//		builder.append(importerTxnId);
//		builder.append(", distributerTxnId=");
//		builder.append(distributerTxnId);
//		builder.append(", retalierTxnId=");
//		builder.append(retalierTxnId);
//		builder.append(", customTxnId=");
//		builder.append(customTxnId);
//		builder.append(", endUserTxnId=");
//		builder.append(endUserTxnId);
//		builder.append(", importerDate=");
//		builder.append(importerDate);
//		builder.append(", distributerDate=");
//		builder.append(distributerDate);
//		builder.append(", retailerDate=");
//		builder.append(retailerDate);
//		builder.append(", customDate=");
//		builder.append(customDate);
//		builder.append(", endUserDate=");
//		builder.append(endUserDate);
//		builder.append(", importerDeviceStatus=");
//		builder.append(importerDeviceStatus);
//		builder.append(", distributerDeviceStatus=");
//		builder.append(distributerDeviceStatus);
//		builder.append(", retailerDeviceStatus=");
//		builder.append(retailerDeviceStatus);
//		builder.append(", customDeviceStatus=");
//		builder.append(customDeviceStatus);
//		builder.append(", endUserDeviceStatus=");
//		builder.append(endUserDeviceStatus);
//		builder.append(", previousImporterDeviceStatus=");
//		builder.append(previousImporterDeviceStatus);
//		builder.append(", previousDistributerDeviceStatus=");
//		builder.append(previousDistributerDeviceStatus);
//		builder.append(", previousRetailerDeviceStatus=");
//		builder.append(previousRetailerDeviceStatus);
//		builder.append(", previousCustomDeviceStatus=");
//		builder.append(previousCustomDeviceStatus);
//		builder.append(", previousEndUserDeviceStatus=");
//		builder.append(previousEndUserDeviceStatus);
//		builder.append(", period=");
//		builder.append(period);
//		builder.append(", endUserCountry=");
//		builder.append(endUserCountry);
//		builder.append("]");
//		return builder.toString();
//	}
//
//}
