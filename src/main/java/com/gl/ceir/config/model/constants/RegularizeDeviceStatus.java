package com.gl.ceir.config.model.constants;

public enum RegularizeDeviceStatus {
	
	PENDING_APPROVAL_FROM_CEIR_ADMIN(0, "Pending Approval From CEIR Admin"), 
	REJECTED_BY_CEIR_ADMIN(1, "Rejected by CEIR Admin"), 
	APPROVED(2, "Approved");

	private int code;
	private String desc;

	RegularizeDeviceStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static RegularizeDeviceStatus getActionNames(int code) {
		for (RegularizeDeviceStatus consignmentStatus : RegularizeDeviceStatus.values()) {
			if (consignmentStatus.getCode() == code)
				return consignmentStatus;
		}

		return null;
	}
}
