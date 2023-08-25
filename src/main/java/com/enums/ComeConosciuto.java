package com.enums;

public enum ComeConosciuto {

	CANALE_RECRUITING("Canale Recruiting"), SOCIAL_NETWORK("Social Network"), LINKEDIN("Linkedin"),
	SITO_WEB_AZIENDALE("Sito Web Aziendale"), CONOSCENTI("Conoscenti");

	private final String value;

	ComeConosciuto(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ComeConosciuto fromString(String value) {
		for (ComeConosciuto b : ComeConosciuto.values()) {
			if (b.value.contains(value)) {
				return b;
			}
		}
		return null;
	}
}
