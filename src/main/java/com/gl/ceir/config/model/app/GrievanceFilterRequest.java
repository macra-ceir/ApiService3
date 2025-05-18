package com.gl.ceir.config.model.app;

import java.time.LocalDateTime;

public class GrievanceFilterRequest {
	public Integer userId;
	public String userType;
	public String startDate;
	public String endDate;
	public String txnId;
	public String grievanceId;
	private int grievanceStatus;
	private String searchString;
	
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getGrievanceId() {
		return grievanceId;
	}
	public void setGrievanceId(String grievanceId) {
		this.grievanceId = grievanceId;
	}
	public int getGrievanceStatus() {
		return grievanceStatus;
	}
	public void setGrievanceStatus(int grievanceStatus) {
		this.grievanceStatus = grievanceStatus;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GrievanceFilterRequest [userId=");
		builder.append(userId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", txnId=");
		builder.append(txnId);
		builder.append(", grievanceId=");
		builder.append(grievanceId);
		builder.append(", grievanceStatus=");
		builder.append(grievanceStatus);
		builder.append(", searchString=");
		builder.append(searchString);
		builder.append("]");
		return builder.toString();
	}
	
}
