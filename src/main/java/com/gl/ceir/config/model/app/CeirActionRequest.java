package com.gl.ceir.config.model.app;

public class CeirActionRequest {

	private int action;
	
	private String userType;
	
	private Long userId;
	
	private Long roleTypeUserId;
	
	private String txnId;
	
	private String remarks;
	
	private Integer featureId;
	
	private Long imei1;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleTypeUserId() {
		return roleTypeUserId;
	}
	public void setRoleTypeUserId(Long roleTypeUserId) {
		this.roleTypeUserId = roleTypeUserId;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	
	
	public Long getImei1() {
		return imei1;
	}
	public void setImei1(Long imei1) {
		this.imei1 = imei1;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsignmentUpdateRequest [action=");
		builder.append(action);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", roleTypeUserId=");
		builder.append(roleTypeUserId);
		builder.append(", txnId=");
		builder.append(txnId);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append("]");
		return builder.toString();
	}

}
