package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
public class MessageConfigurationDb implements Serializable {

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
	
	@Column(length = 1000)
	private String value;
	private String description;
	
	private Integer channel;
	@Transient
	private String channelInterp;
	
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
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getChannelInterp() {
		return channelInterp;
	}
	public void setChannelInterp(String channelInterp) {
		this.channelInterp = channelInterp;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageConfigurationDb [id=");
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
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", channelInterp=");
		builder.append(channelInterp);
		builder.append("]");
		return builder.toString();
	}
	
}
