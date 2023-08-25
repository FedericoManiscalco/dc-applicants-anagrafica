package com.enums;

public enum Contratto {

	CCNL_METALMECCANICO("CCNL Metalmeccanico"), CCNL_COMMERCIO("CCNL Commercio"), PARTITA_IVA("Partita Iva"),
	ALTRO("Altro");

	private final String value;

	Contratto(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Contratto fromString(String value) {
		for (Contratto b : Contratto.values()) {
			if (b.value.toLowerCase().contains(value.toLowerCase())) {
				return b;
			}
		}
		return null;
	}

}
