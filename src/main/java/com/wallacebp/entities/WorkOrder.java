package com.wallacebp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.wallacebp.enums.Priority;
import com.wallacebp.enums.Status;

public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate startDate = LocalDate.now();
	private LocalDate endDate;
	private Priority priority;
	private Status status;
	private String clientName;
	private String clientAddress;
	private String headline;
	private String description;

	private Manager manager;
	private Dispatcher dispatcher;

	public WorkOrder() {
	}

	public WorkOrder(Long id, Priority priority, Status status, String clientName, String clientAddress,
			String headline, String description, Manager manager, Dispatcher dispatcher) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.headline = headline;
		this.description = description;
		this.manager = manager;
		this.dispatcher = dispatcher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkOrder other = (WorkOrder) obj;
		return Objects.equals(id, other.id);
	}

}
