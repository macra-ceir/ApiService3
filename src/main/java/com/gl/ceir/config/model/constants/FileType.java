package com.gl.ceir.config.model.constants;

public enum FileType {
	Full(0), Incremental(1);
	private int code;

	FileType(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static FileType getActionNames(int code) {
		for (FileType codes : FileType.values()) {
			if (codes.code == code )
				return codes;
		}

		return null;
	}
	
}
