package com.enums;

public enum Livello {

	D1("D1"), D2("D2"), C1("C1"), C2("C2"), C3("C3"), B1("B1"), B2("B2"), B3("B3"), A1("A1");

	private final String value;

	Livello(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Livello fromString(String value) {
		for (Livello b : Livello.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}

}
