package com.gl.ceir.config.model.app;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GrievanceMsgHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long grievanceMsgId;
	
	@Column(name="grievance_id")
	private String grievanceId;
	
	private Integer userId ;

	private String userType;
	
	private String fileName;
	
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime createdOn;


	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime modifiedOn;
	
	@Column(length = 2000,columnDefinition="Text")
	private String reply;
	
//	@OneToOne
//	@JoinColumn(name="grievance_id",insertable = false, updatable = false)
//	private Grievance grievance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrievanceMsgId() {
		return grievanceMsgId;
	}

	public void setGrievanceMsgId(Long grievanceMsgId) {
		this.grievanceMsgId = grievanceMsgId;
	}

	public String getGrievanceId() {
		return grievanceId;
	}

	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

//	public Grievance getGrievance() {
//		return grievance;
//	}
//
//	public void setGrievance(Grievance grievance) {
//		this.grievance = grievance;
//	}
}
