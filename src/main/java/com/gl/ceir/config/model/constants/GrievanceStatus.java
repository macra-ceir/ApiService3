package com.gl.ceir.config.model.constants;

public enum GrievanceStatus {
	NEW(0), PENDING_WITH_ADMIN(1), PENDING_WITH_USER(2), CLOSED(3);

	private int code;

	GrievanceStatus(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static GrievanceStatus getActionNames(int code) {
		for (GrievanceStatus codes : GrievanceStatus.values()) {
			if (codes.code == code )
				return codes;
		}

		return null;
	}
}
