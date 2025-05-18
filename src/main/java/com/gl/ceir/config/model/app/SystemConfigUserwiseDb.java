package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class SystemConfigUserwiseDb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	private LocalDateTime createdOn;

	@UpdateTimestamp
	private LocalDateTime modifiedOn;

	@NotNull
	private String tagId;

	@NotNull
	private Integer userTypeId;
	
	private Integer featureId;
	
	@NotNull
	private Integer value;
	
	@Transient
	private String interp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInterp() {
		return interp;
	}

	public void setInterp(String interp) {
		this.interp = interp;
	}
	public Integer getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConfigUserwiseDb [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", tagId=");
		builder.append(tagId);
		builder.append(", userTypeId=");
		builder.append(userTypeId);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
