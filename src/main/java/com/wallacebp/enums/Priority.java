package com.wallacebp.enums;

public enum Priority {

	LOW(0, "LOW"), MEDIUM(1, "MEDIUM"), HIGH(2, "HIGH");

	private Integer cod;
	private String description;

	private Priority(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Priority toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Priority x : Priority.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Status: " + cod);
	}

}
