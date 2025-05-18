package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
public class CheckImeiModel implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   
	private String  name ;
	private String  ruleOrder ;
	private String  userType ;
	private String  output ;
	private String  feature ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;

	
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRuleOrder() {
		return ruleOrder;
	}
	public void setRuleOrder(String ruleOrder) {
		this.ruleOrder = ruleOrder;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}

































