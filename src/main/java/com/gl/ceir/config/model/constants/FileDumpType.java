package com.gl.ceir.config.model.constants;

public enum FileDumpType {
	Gray(0), Black(1);
	private int code;

	FileDumpType(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static FileDumpType getActionNames(int code) {
		for (FileDumpType codes : FileDumpType.values()) {
			if (codes.code == code )
				return codes;
		}

		return null;
	}
}
