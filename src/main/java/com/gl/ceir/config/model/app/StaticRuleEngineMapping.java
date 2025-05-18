package com.gl.ceir.config.model.app;

import java.io.Serializable;

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
public class StaticRuleEngineMapping implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 20)
	private String feature;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RulesNames name;
	
	@NotNull
	@Column(length = 20)
	private String graceType;
	
	@NotNull
	@Column(length = 20)
	private String postGraceType;
	
	@NotNull
	@Column(length = 20)
	private String userType;

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

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getGraceType() {
		return graceType;
	}

	public void setGraceType(String graceType) {
		this.graceType = graceType;
	}

	public String getPostGraceType() {
		return postGraceType;
	}

	public void setPostGraceType(String postGraceType) {
		this.postGraceType = postGraceType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StaticRuleEngineMapping [id=");
		builder.append(id);
		builder.append(", feature=");
		builder.append(feature);
		builder.append(", name=");
		builder.append(name);
		builder.append(", graceType=");
		builder.append(graceType);
		builder.append(", postGraceType=");
		builder.append(postGraceType);
		builder.append(", userType=");
		builder.append(userType);
		builder.append("]");
		return builder.toString();
	}

	
}
