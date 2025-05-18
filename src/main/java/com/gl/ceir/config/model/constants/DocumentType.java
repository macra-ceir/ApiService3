package com.gl.ceir.config.model.constants;

import java.util.ArrayList;
import java.util.List;

public enum DocumentType {
	IDENTITY_CARD("IDENTITY_CARD"), PHONE_BILL("PHONE_BILL"), PASSPORT("PASSPORT");

	private String name;

	DocumentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static List<String> getDocumentTypes() {
		List<String> list = new ArrayList<>();
		for (DocumentType documentType : DocumentType.values()) {
			list.add(documentType.toString());
		}
		return list;
	}

}
