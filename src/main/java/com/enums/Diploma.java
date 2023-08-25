package com.enums;

public enum Diploma {

	PERITO_INFORMATICO("Diploma Perito Informatico"), LICEO_SCIENTIFICO("Diploma Liceo Scientifico"),
	LICEO_CLASSICO("Diploma Liceo Classico"), ALTRO("Altro");

	private final String value;

	Diploma(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Diploma fromString(String value) {
		for (Diploma b : Diploma.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}

}
