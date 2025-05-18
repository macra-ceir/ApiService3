package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Cacheable
@Audited
@Table(name = "sys_param")
// @AuditTable(value = "sys_param_aud", schema = "aud")

public class SystemConfigurationDb implements Serializable {

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
	
	private Integer type; // have two values USER/SYSTEM.
	@Transient
	private String typeInterp;
	
	private String remark;

	private String featureName;
	
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTypeInterp() {
		return typeInterp;
	}
	public void setTypeInterp(String typeInterp) {
		this.typeInterp = typeInterp;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConfigurationDb [id=");
		builder.append(id);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", value=");
		builder.append(value);
		builder.append(", featureName=");
		builder.append(featureName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", type=");
		builder.append(type);
		builder.append(", typeInterp=");
		builder.append(typeInterp);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

}
