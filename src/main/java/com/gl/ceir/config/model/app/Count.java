package com.gl.ceir.config.model.app;

import java.io.Serializable;

public class Count implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long allowed;
	private Long current;
	
	public Count(Long allowed, Long current) {
		// TODO Auto-generated constructor stub
		this.allowed = allowed;
		this.current = current;
	}

	public Long getAllowed() {
		return allowed;
	}

	public void setAllowed(Long allowed) {
		this.allowed = allowed;
	}

	public Long getCurrent() {
		return current;
	}

	public void setCurrent(Long current) {
		this.current = current;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Count [allowed=");
		builder.append(allowed);
		builder.append(", current=");
		builder.append(current);
		builder.append("]");
		return builder.toString();
	}

}
