package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class ActionsConfigDb extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private long stateId;
	
	@NotNull
	@Column(length = 20)
	private String action;
	
	@NotNull
	@Column(length = 1)
	private String isEnable;

	public ActionsConfigDb() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActionConfigDb [id=");
		builder.append(id);
		builder.append(", stateId=");
		builder.append(stateId);
		builder.append(", action=");
		builder.append(action);
		builder.append(", isEnable=");
		builder.append(isEnable);
		builder.append("]");
		return builder.toString();
	}

}
