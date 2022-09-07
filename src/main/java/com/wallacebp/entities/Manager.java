package com.wallacebp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wallacebp.enums.Profile;

@Entity
public class Manager extends Person {
	private static final long serialVersionUID = 1L;

	private String email;
	private String phoneNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private Set<WorkOrder> orders = new HashSet<>();

	public Manager() {
		addProfiles(Profile.MANAGER);
	}

	public Manager(Long id, String name, String email, String phoneNumber) {
		super(id, name);
		this.email = email;
		this.phoneNumber = phoneNumber;
		addProfiles(Profile.MANAGER);
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

	public Set<WorkOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<WorkOrder> orders) {
		this.orders = orders;
	}

}
