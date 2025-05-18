package com.gl.ceir.config.model.constants;

public enum WebActionDbState {
	SUCCESS(3), INIT(0), PROCESSING(1), ERROR(2);
	
	private int code;

	WebActionDbState(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static WebActionDbState getActionNames(int code) {
		for (WebActionDbState codes : WebActionDbState.values()) {
			if (codes.equals(code))
				return codes;
		}

		return null;
	}
}
