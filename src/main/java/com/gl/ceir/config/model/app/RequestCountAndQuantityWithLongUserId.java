package com.gl.ceir.config.model.app;

import java.util.List;

public class RequestCountAndQuantityWithLongUserId {
	private long userId;
	private List<Integer> status;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<Integer> getStatus() {
		return status;
	}
	public void setStatus(List<Integer> status) {
		this.status = status;
	}
	
}
