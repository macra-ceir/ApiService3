package com.gl.ceir.config.model.app;

public class GrievanceFileModel {
	private String grievanceId;
	
	private String grievanceStatus;
	
	private String txnId;

	private String user;
	
	private String userType;
	
	private String category;
	
	private String fileName;
	
	private String createdOn;

	private String modifiedOn;

	private String remarks;
	
	
	public String getGrievanceId() {
		return grievanceId;
	}

	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getGrievanceStatus() {
		return grievanceStatus;
	}

	public void setGrievanceStatus(String grievanceStatus) {
		this.grievanceStatus = grievanceStatus;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategoryId(String category) {
		this.category = category;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Grievance:{grievanceId:"+grievanceId+",user:"+user+",userType:"+userType+",grievanceStatus"+grievanceStatus+","
				+ "txnId:"+txnId+",category:"+category+",fileName"+fileName+",createdOn"+createdOn+",modifiedOn:"+modifiedOn+","
						+ "remarks"+remarks+"}";
	}
}
