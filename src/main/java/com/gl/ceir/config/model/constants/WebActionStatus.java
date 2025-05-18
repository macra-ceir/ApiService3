package com.gl.ceir.config.model.constants;

public enum WebActionStatus {
	
	INIT(0, "INIT"), PROCESSING(1, "Processing");

	private int code;
	private String desc;

	WebActionStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static WebActionStatus getActionNames(int code) {
		for (WebActionStatus consignmentStatus : WebActionStatus.values()) {
			if (consignmentStatus.getCode() == code)
				return consignmentStatus;
		}

		return null;
	}
}
