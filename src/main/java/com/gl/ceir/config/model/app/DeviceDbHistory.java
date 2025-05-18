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
//public class DeviceDbHistory implements Serializable {
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
//	private String supplierId;
//
//	private String fileName;
//	private String filePath;
//	private String deviceAction;
//	private String invoiceNumber;    
//
//	private Integer	operation;       
//	private String roleType;     
//	private String 	txnId;          
//	private Long userId;         
//	private String supplierName;
//
//	private Integer taxPaidStatus;
//
//	private String deviceStatus;
//
//	private LocalDateTime deviceLaunchDate;
//
//	private String multipleSimStatus;
//	private String deviceIdType;
//	private String snOfDevice; 
//	private String deviceType;   
//	private String imeiEsnEeid;
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
//	public String getSupplierId() {
//		return supplierId;
//	}
//	public void setSupplierId(String supplierId) {
//		this.supplierId = supplierId;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getFilePath() {
//		return filePath;
//	}
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}
//	public String getDeviceAction() {
//		return deviceAction;
//	}
//	public void setDeviceAction(String deviceAction) {
//		this.deviceAction = deviceAction;
//	}
//	public String getInvoiceNumber() {
//		return invoiceNumber;
//	}
//	public void setInvoiceNumber(String invoiceNumber) {
//		this.invoiceNumber = invoiceNumber;
//	}
//	public int getOperation() {
//		return operation;
//	}
//	public void setOperation(int operation) {
//		this.operation = operation;
//	}
//	public String getRoleType() {
//		return roleType;
//	}
//	public void setRoleType(String roleType) {
//		this.roleType = roleType;
//	}
//	public String getTxnId() {
//		return txnId;
//	}
//	public void setTxnId(String txnId) {
//		this.txnId = txnId;
//	}
//	public Long getUserId() {
//		return userId;
//	}
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//	public String getSupplierName() {
//		return supplierName;
//	}
//	public void setSupplierName(String supplierName) {
//		this.supplierName = supplierName;
//	}
//	public String getDeviceStatus() {
//		return deviceStatus;
//	}
//	public void setDeviceStatus(String deviceStatus) {
//		this.deviceStatus = deviceStatus;
//	}
//	
//	public String getMultipleSimStatus() {
//		return multipleSimStatus;
//	}
//	public void setMultipleSimStatus(String multipleSimStatus) {
//		this.multipleSimStatus = multipleSimStatus;
//	}
//	public String getDeviceIdType() {
//		return deviceIdType;
//	}
//	public void setDeviceIdType(String deviceIdType) {
//		this.deviceIdType = deviceIdType;
//	}
//	public String getDeviceType() {
//		return deviceType;
//	}
//	public void setDeviceType(String deviceType) {
//		this.deviceType = deviceType;
//	}
//	public String getImeiEsnEeid() {
//		return imeiEsnEeid;
//	}
//	public void setImeiEsnEeid(String imeiEsnEeid) {
//		this.imeiEsnEeid = imeiEsnEeid;
//	}
//	public Integer getTaxPaidStatus() {
//		return taxPaidStatus;
//	}
//	public void setTaxPaidStatus(Integer taxPaidStatus) {
//		this.taxPaidStatus = taxPaidStatus;
//	}
//	public LocalDateTime getDeviceLaunchDate() {
//		return deviceLaunchDate;
//	}
//	public void setDeviceLaunchDate(LocalDateTime deviceLaunchDate) {
//		this.deviceLaunchDate = deviceLaunchDate;
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
//	public void setOperation(Integer operation) {
//		this.operation = operation;
//	}
//
//}
