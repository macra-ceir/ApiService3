package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NationlismDetails implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long nationalismId;
	private Date createdOn;
	private Date modifiedOn;
	private String name;
	private String passportNumber;
	private String visaNumber;
	private String visaExpireDate;
	private String emailId;
	private String country;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNationalismId() {
		return nationalismId;
	}
	public void setNationalismId(Long nationalismId) {
		this.nationalismId = nationalismId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getVisaNumber() {
		return visaNumber;
	}
	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}
	public String getVisaExpireDate() {
		return visaExpireDate;
	}
	public void setVisaExpireDate(String visaExpireDate) {
		this.visaExpireDate = visaExpireDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
}
