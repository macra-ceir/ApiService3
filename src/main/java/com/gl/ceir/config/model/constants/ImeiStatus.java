package com.gl.ceir.config.model.constants;

public enum ImeiStatus {
	SYSTEM_REGULARIZED("SYSTEM_REGULARIZED"), AUTO_REGULARIZED("AUTO_REGULARIZED"), USER_REGULARIZED(
			"USER_REGULARIZED"), PENDING_TO_REGUARIZED("PENDING_TO_REGUARIZED");
	private String name;

	ImeiStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ImeiStatus getImeiStatus(String name) {
		for (ImeiStatus names : ImeiStatus.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}