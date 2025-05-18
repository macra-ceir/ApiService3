package com.gl.ceir.config.model.constants;

public enum WebActionDbFeature {

	CONSIGNMENT("CONSIGNMENT"), STOCK("STOCK"), GRIEVANCE("GRIEVANCE");
	private String name;

	WebActionDbFeature(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static WebActionDbFeature getActionNames(String name) {
		for (WebActionDbFeature names : WebActionDbFeature.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}
