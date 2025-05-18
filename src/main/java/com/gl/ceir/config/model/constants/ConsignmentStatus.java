package com.gl.ceir.config.model.constants;

public enum ConsignmentStatus {
	
	INIT(0, "INIT"), PROCESSING(1, "Processing"), REJECTED_BY_SYSTEM(2, "Rejected By System"), 
	
	PENDING_APPROVAL_FROM_CEIR_AUTHORITY(3, "Pending Approval From CEIR Authority"), 
	
	REJECTED_BY_CEIR_AUTHORITY(4, "Rejected by CEIR Authority"), 
	
	PENDING_APPROVAL_FROM_CUSTOMS(5, "Pending Approval From Customs"), APPROVED(6, "Approved"), 
	
	REJECTED_BY_CUSTOMS(7, "Rejected By Customs"), WITHDRAWN_BY_IMPORTER(8, "Withdrawn By Importer"),
	
	WITHDRAWN_BY_CEIR(9, "Withdrawn By CEIR"), STOLEN(10,"Stolen");

	private int code;
	private String desc;

	ConsignmentStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static ConsignmentStatus getActionNames(int code) {
		for (ConsignmentStatus consignmentStatus : ConsignmentStatus.values()) {
			if (consignmentStatus.getCode() == code)
				return consignmentStatus;
		}

		return null;
	}
}
