package com.gl.ceir.config.model.app;

public class CheckDeviceReponse {

	private String tacNumber;
	private String brandName;
	private String modelName;
	private String status;
        
        
	public String getTacNumber() {
		return tacNumber;
	}
	public void setTacNumber(String tacNumber) {
		this.tacNumber = tacNumber;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CheckDeviceReponse [tacNumber=" + tacNumber + ", brandName=" + brandName + ", modelName=" + modelName
				+ ", status=" + status + "]";
	}
	
	
	
}
