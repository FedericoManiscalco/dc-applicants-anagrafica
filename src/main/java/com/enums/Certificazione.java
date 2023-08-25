package com.enums;

public enum Certificazione {

	JAVA_SE_PROGRAMMER("Java SE Programmer"), JAVA_ARCHITECT("Java Architect"), ALTRO("Altro");

	private final String value;

	Certificazione(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Certificazione fromString(String value) {
		for (Certificazione b : Certificazione.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}

}
