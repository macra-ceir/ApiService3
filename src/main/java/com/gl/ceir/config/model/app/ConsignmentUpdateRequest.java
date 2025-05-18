package com.gl.ceir.config.model.app;

public class ConsignmentUpdateRequest {

	private int action;
	private String roleType;
	private Long userId;
	private Long roleTypeUserId;
	private String txnId;
	private String remarks;
	private Integer featureId;
	private Integer requestType;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
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
	public Integer getRequestType() {
		return requestType;
	}
	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsignmentUpdateRequest [action=");
		builder.append(action);
		builder.append(", roleType=");
		builder.append(roleType);
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
