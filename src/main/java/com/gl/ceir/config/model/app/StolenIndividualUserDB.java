package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class StolenIndividualUserDB extends StolenandRecoveryMgmt implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 */
	
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime modifiedOn;
	private String nid;
	private String firstName;  
	private String middleName;
	private String lastName;
	
	// user address fields.
	private String propertyLocation;
	private String street;
	private String locality;
	@NotNull
	@Column(length = 50)
	private String district;
	@NotNull
	@Column(length = 50)
	private String commune;
	@NotNull
	@Column(length = 50)
	private String village;
	@NotNull
	private Integer postalCode;
	
	private String province;
	private String country;
	private String email;
	@Column(length = 15)
	private String phoneNo;
	private Integer docType;
	@Transient
	private Integer docTypeInterp;
	@Column(length = 15)
	private String alternateContactNumber;
	@Column(length = 50)
	private String deviceBrandName;
	
	private Long imei_esn_meid;
	private Integer deviceIdType;
	private Integer deviceType;
	@Column(length = 50)
	private String modelNumber;
	@NotNull
	@Column(length = 15)
	private String contactNumber;
	private Integer operator;
	private Integer complaintType;
	
	// Place of device Stolen
	private String deviceStolenPropertyLocation;
	private String deviceStolenStreet;
	private String deviceStolenLocality;
	@NotNull
	@Column(length = 50)
	private String deviceStolenDistrict;
	@NotNull
	@Column(length = 50)
	private String deviceStolenCommune;
	@NotNull
	@Column(length = 50)
	private String deviceStolenVillage;
	@NotNull
	private Integer deviceStolenPostalCode;
	
	private String remark;
	
	/*
	 * @OneToMany(mappedBy = "endUserDB", cascade = CascadeType.ALL,fetch =
	 * FetchType.LAZY) private List<RegularizeDeviceDb> regularizeDeviceDbs ;
	 */

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPropertyLocation() {
		return propertyLocation;
	}
	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getDocType() {
		return docType;
	}
	public void setDocType(Integer docType) {
		this.docType = docType;
	}
	public Integer getDocTypeInterp() {
		return docTypeInterp;
	}
	public void setDocTypeInterp(Integer docTypeInterp) {
		this.docTypeInterp = docTypeInterp;
	}
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public String getDeviceBrandName() {
		return deviceBrandName;
	}
	public void setDeviceBrandName(String deviceBrandName) {
		this.deviceBrandName = deviceBrandName;
	}
	public Long getImei_esn_meid() {
		return imei_esn_meid;
	}
	public void setImei_esn_meid(Long imei_esn_meid) {
		this.imei_esn_meid = imei_esn_meid;
	}
	public Integer getDeviceIdType() {
		return deviceIdType;
	}
	public void setDeviceIdType(Integer deviceIdType) {
		this.deviceIdType = deviceIdType;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public Integer getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(Integer complaintType) {
		this.complaintType = complaintType;
	}
	public String getDeviceStolenPropertyLocation() {
		return deviceStolenPropertyLocation;
	}
	public void setDeviceStolenPropertyLocation(String deviceStolenPropertyLocation) {
		this.deviceStolenPropertyLocation = deviceStolenPropertyLocation;
	}
	public String getDeviceStolenStreet() {
		return deviceStolenStreet;
	}
	public void setDeviceStolenStreet(String deviceStolenStreet) {
		this.deviceStolenStreet = deviceStolenStreet;
	}
	public String getDeviceStolenLocality() {
		return deviceStolenLocality;
	}
	public void setDeviceStolenLocality(String deviceStolenLocality) {
		this.deviceStolenLocality = deviceStolenLocality;
	}
	public String getDeviceStolenDistrict() {
		return deviceStolenDistrict;
	}
	public void setDeviceStolenDistrict(String deviceStolenDistrict) {
		this.deviceStolenDistrict = deviceStolenDistrict;
	}
	public String getDeviceStolenCommune() {
		return deviceStolenCommune;
	}
	public void setDeviceStolenCommune(String deviceStolenCommune) {
		this.deviceStolenCommune = deviceStolenCommune;
	}
	public String getDeviceStolenVillage() {
		return deviceStolenVillage;
	}
	public void setDeviceStolenVillage(String deviceStolenVillage) {
		this.deviceStolenVillage = deviceStolenVillage;
	}
	public Integer getDeviceStolenPostalCode() {
		return deviceStolenPostalCode;
	}
	public void setDeviceStolenPostalCode(Integer deviceStolenPostalCode) {
		this.deviceStolenPostalCode = deviceStolenPostalCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EndUserDB [createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", nid=");
		builder.append(nid);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", propertyLocation=");
		builder.append(propertyLocation);
		builder.append(", street=");
		builder.append(street);
		builder.append(", locality=");
		builder.append(locality);
		builder.append(", province=");
		builder.append(province);
		builder.append(", country=");
		builder.append(country);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append("]");
		return builder.toString();
	}

}


