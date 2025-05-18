package com.gl.ceir.config.model.constants;

public enum WebActionDbSubFeature {
	CONSIGNMENT_REGISTER("REGISTER"), UPDATE("UPDATE"), DELETE(
			"DELETE"), UPLOAD("UPLOAD");
	private String name;

	WebActionDbSubFeature(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static WebActionDbSubFeature getActionNames(String name) {
		for (WebActionDbSubFeature names : WebActionDbSubFeature.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}
