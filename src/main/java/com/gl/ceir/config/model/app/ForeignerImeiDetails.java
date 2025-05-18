package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ForeignerImeiDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createdOn;
	private Date updatedOn;
	private Long firstImei;
	private Long firstMsisdn;
	private Long secondImei;
	private Long secondMsidn;
	private String passportNumber;
	
	private String status;

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
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Long getFirstImei() {
		return firstImei;
	}
	public void setFirstImei(Long firstImei) {
		this.firstImei = firstImei;
	}
	public Long getFirstMsisdn() {
		return firstMsisdn;
	}
	public void setFirstMsisdn(Long firstMsisdn) {
		this.firstMsisdn = firstMsisdn;
	}
	public Long getSecondImei() {
		return secondImei;
	}
	public void setSecondImei(Long secondImei) {
		this.secondImei = secondImei;
	}
	public Long getSecondMsidn() {
		return secondMsidn;
	}
	public void setSecondMsidn(Long secondMsidn) {
		this.secondMsidn = secondMsidn;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	





}
