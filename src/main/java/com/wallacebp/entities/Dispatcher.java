package com.wallacebp.entities;

import java.util.HashSet;
import java.util.Set;

public class Dispatcher extends Person {
	private static final long serialVersionUID = 1L;

	private Set<WorkOrder> orders = new HashSet<>();

	public Dispatcher() {
	}

	public Dispatcher(Long id, String name, Set<WorkOrder> orders) {
		super(id, name);
		this.orders = orders;
	}

	public Set<WorkOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<WorkOrder> orders) {
		this.orders = orders;
	}

}
