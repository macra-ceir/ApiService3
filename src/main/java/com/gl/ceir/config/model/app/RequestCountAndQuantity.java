package com.gl.ceir.config.model.app;

import java.util.List;

public class RequestCountAndQuantity {
	private Integer userId;
	private List<Integer> status;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getStatus() {
		return status;
	}
	public void setStatus(List<Integer> status) {
		this.status = status;
	}
}
