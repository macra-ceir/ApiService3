package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Table;


@Entity
@Table(name = "sys_param_list_value")
public class SystemConfigListDb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@CreationTimestamp
	@JsonIgnore
	private Date createdOn;

	@UpdateTimestamp
	@JsonIgnore
	private Date modifiedOn;
	
	@JsonIgnore
	
        String tag;
	
	 Integer value;

    @Column(name = "interpretation")
	 String interp;
	
	@Column(length = 10)
	private String tagId;
	
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
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getInterp() {
		return interp;
	}
	public void setInterp(String interp) {
		this.interp = interp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConfigListDb [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", value=");
		builder.append(value);
		builder.append(", interp=");
		builder.append(interp);
		builder.append(", tagId=");
		builder.append(tagId);
		builder.append("]");
		return builder.toString();
	}
	
}