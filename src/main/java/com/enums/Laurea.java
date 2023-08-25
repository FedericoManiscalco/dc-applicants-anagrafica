package com.enums;

public enum Laurea {

	ING_INFORM_TRIENNALE("Laurea in Ingegneria Informatica Triennale"),
	ING_INFORM_MAGISTRALE("Laurea in Ingegneria Informatica Magistrale"), INFORMATICA("Laurea in Informatica"),
	ING_GESTIONALE_TRIENNALE("Laurea in Ingegneria Gestionale Triennale"),
	ING_GESTIONALE_MAGISTRALE("Laurea in Ingegneria Gestionale Magistrale"), ALTRO("Altro");

	private final String value;

	Laurea(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Laurea fromString(String value) {
		for (Laurea b : Laurea.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}

}
