package com.enums;

public enum Qualifica {

	JAVA_PROGRAMMER("Java Programmer"), MICROSOFT_PROGRAMMER("Microsoft Programmer"), ALTRO("Altro");

	private final String value;

	Qualifica(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Qualifica fromString(String value) {
		for (Qualifica b : Qualifica.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}

}
