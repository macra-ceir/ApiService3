package com.gl.ceir.config.model.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.gl.ceir.config.model.constants.RulesNames;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class RuleEngine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private RulesNames name;

	@NotNull
	private String description;
	
	@NotNull
	@Column(length = 20)
	private String state;
	
	@NotNull
	@Column(length = 5)
	private String output;
	
	@NotNull
	private Date createdOn;
	
	@NotNull
	private Date modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RulesNames getName() {
		return name;
	}

	public void setName(RulesNames name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RuleEngine [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", state=");
		builder.append(state);
		builder.append(", output=");
		builder.append(output);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append("]");
		return builder.toString();
	}

}
