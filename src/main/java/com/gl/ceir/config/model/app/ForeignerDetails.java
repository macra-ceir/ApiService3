package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class ForeignerDetails implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long foreignerId;

	private String name;
	private String passportNumber;

	private String visaNumber;
	private String visaExpireDate;
	private String emailId;
	private String country;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	private Date updatedOn;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getForeignerId() {
		return foreignerId;
	}
	public void setForeignerId(Long foreignerId) {
		this.foreignerId = foreignerId;
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	





}
