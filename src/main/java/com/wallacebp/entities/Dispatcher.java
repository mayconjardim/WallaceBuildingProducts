package com.wallacebp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.wallacebp.enums.Profile;

@Entity
public class Dispatcher extends Person {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "dispatcher")
	private Set<WorkOrder> orders = new HashSet<>();

	public Dispatcher() {
		addProfiles(Profile.DISPATCHER);
	}

	public Dispatcher(Long id, String name, Set<WorkOrder> orders) {
		super(id, name);
		this.orders = orders;
		addProfiles(Profile.DISPATCHER);
	}

	public Set<WorkOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<WorkOrder> orders) {
		this.orders = orders;
	}

}
