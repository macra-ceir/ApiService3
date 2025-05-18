package com.gl.ceir.config.model.app;

public class ResponseCountAndQuantity {
	private long count;
	private long quantity;
	public ResponseCountAndQuantity( long count) {
		this.count = count;
	}
	public ResponseCountAndQuantity( long count, long quantity) {
		this.count = count;
		this.quantity = quantity;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
