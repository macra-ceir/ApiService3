package com.gl.ceir.config.model.app;

public class GrievanceReply {
	private String grievanceId;
	private Integer userId ;
	private String userType;
	private Integer grievanceStatus;
	private String txnId;
	private int categoryId;
	private String fileName;
	private String reply;
	private long featureId;
	public String getGrievanceId() {
		return grievanceId;
	}
	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getGrievanceStatus() {
		return grievanceStatus;
	}
	public void setGrievanceStatus(Integer grievanceStatus) {
		this.grievanceStatus = grievanceStatus;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}
}
