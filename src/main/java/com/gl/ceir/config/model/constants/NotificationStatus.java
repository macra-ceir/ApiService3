package com.gl.ceir.config.model.constants;

public enum NotificationStatus {
	INIT(1), PROCESSING(1), SUCCESS(2);
	
	private int code;

	NotificationStatus(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static NotificationStatus getActionNames(int code) {
		for (NotificationStatus codes : NotificationStatus.values()) {
			if (codes.getCode() == code)
				return codes;
		}

		return null;
	}
}
