package com.wallacebp.enums;

public enum Profile {

	ADMIN(0, "ROLE_ADMIN"), MANAGER(1, "ROLE_MANAGER"), DISPATCHER(2, "ROLE_DISPATCHER");

	private Integer cod;
	private String description;

	private Profile(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Status: " + cod);
	}

}
