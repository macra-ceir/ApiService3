package com.gl.ceir.config.model.constants;

public enum ActionNames {
	USER_REGULARIZED("USER_REGULARIZED"), SYSTEM_REGULARIZED("SYSTEM_REGULARIZED"), AUTO_REGULARIZED(
			"AUTO_REGULARIZED"), NO_ACTION("NO_ACTION");
	private String name;

	ActionNames(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ActionNames getActionNames(String name) {
		for (ActionNames names : ActionNames.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}
