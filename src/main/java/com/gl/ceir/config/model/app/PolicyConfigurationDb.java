package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class PolicyConfigurationDb implements Serializable {

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
	
	private String tag;
	
	private String value;
	
	private String description;

	private String period;
	
	private Integer status;
	@Transient
	private String statusInterp;
	
	private String remark;
	
	private Integer type;
	
	private int policyOrder;
	
	@NotNull
	private Integer active;
	
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPolicyOrder() {
		return policyOrder;
	}
	public void setPolicyOrder(int policyOrder) {
		this.policyOrder = policyOrder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getStatusInterp() {
		return statusInterp;
	}
	public void setStatusInterp(String statusInterp) {
		this.statusInterp = statusInterp;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PolicyConfigurationDb [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", value=");
		builder.append(value);
		builder.append(", description=");
		builder.append(description);
		builder.append(", period=");
		builder.append(period);
		builder.append(", status=");
		builder.append(status);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", type=");
		builder.append(type);
		builder.append(", policyOrder=");
		builder.append(policyOrder);
		builder.append("]");
		return builder.toString();
	}

}
