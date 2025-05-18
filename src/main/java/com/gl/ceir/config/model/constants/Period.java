package com.gl.ceir.config.model.constants;

public enum Period {

	GRACE("GRACE"), POST_GRACE("POST_GRACE");

	private String name;

	Period(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Period getPeriod(String name) {
		for (Period names : Period.values()) {
			System.out.println("name:" + name + ", names:" + names.toString() + ", " + name.equals(names.getName()));
			if (name.equals(names.getName()))
				return names;
		}
		return null;
	}
}
