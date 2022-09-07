package com.wallacebp.entities;

import com.wallacebp.enums.Profile;

public class Admin extends Person {
	private static final long serialVersionUID = 1L;

	private String password;

	public Admin() {
		addProfiles(Profile.ADMIN);
	}
	

	public Admin(Long id, String name, String password) {
		super(id, name);
		this.password = password;
		addProfiles(Profile.ADMIN);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
