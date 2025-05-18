package com.gl.ceir.config.model.constants;

public enum TaxStatus {
	TAX_PAID(0), TAX_NOT_PAID(1), REGULARIZED(2), BLOCKED(3);
	
	private Integer code;

	TaxStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static TaxStatus getActionNames(String name) {
		for (TaxStatus names : TaxStatus.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}
