package com.gl.ceir.config.model.app;

import java.util.ArrayList;
import java.util.List;


public enum DocumentStatus {
	PENDING("PENDING"), APPROVED("APPROVED"), REJECTED("REJECTED");

	private String name;

	DocumentStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static List<String> getDocumentStatus() {
		List<String> list = new ArrayList<>();
		for (DocumentStatus documentStatus : DocumentStatus.values()) {
			list.add(documentStatus.toString());
		}
		return list;
	}

	public static DocumentStatus getDocumentStatus(String name) {
		for (DocumentStatus names : DocumentStatus.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
}
