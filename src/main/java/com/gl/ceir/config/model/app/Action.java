package com.gl.ceir.config.model.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.gl.ceir.config.model.constants.ActionNames;

import io.swagger.annotations.ApiModel;

@Entity
public class Action  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
        
	@Enumerated(EnumType.STRING)
	private ActionNames name;

	public Action() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActionNames getName() {
		return name;
	}

	public void setName(ActionNames name) {
		this.name = name;
	}

}
