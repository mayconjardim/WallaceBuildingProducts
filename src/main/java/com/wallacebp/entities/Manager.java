package com.wallacebp.entities;

public class Manager extends Person {
	private static final long serialVersionUID = 1L;

	private String email;
	private String phoneNumber;

	public Manager() {
	}

	public Manager(Long id, String name, String email, String phoneNumber) {
		super(id, name);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
