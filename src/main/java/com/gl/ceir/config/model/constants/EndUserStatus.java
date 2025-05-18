package com.gl.ceir.config.model.constants;

public enum EndUserStatus {

	PAID(1), NOTPAID(0), REGULERISED(2); 


	private int code;
	private String desc;

	EndUserStatus(int code) {
		this.code = code;

	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static EndUserStatus getActionNames(int code) {
		for (EndUserStatus consignmentStatus : EndUserStatus.values()) {
			if (consignmentStatus.getCode() == code)
				return consignmentStatus;
		}

		return null;
	}
}
