package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class NullMsisdnRegularized implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long msisdn;

	public Long getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Long msisdn) {
		this.msisdn = msisdn;
	}
	
	

}
