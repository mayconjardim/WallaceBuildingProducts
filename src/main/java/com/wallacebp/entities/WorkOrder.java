package com.wallacebp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wallacebp.enums.Priority;
import com.wallacebp.enums.Status;

@Entity
public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate startDate = LocalDate.now();

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate endDate;
	private Priority priority;
	private Status status;
	private String clientName;
	private String clientAddress;
	private String clientCity;
	private String clientZip;
	private String headline;
	private String description;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@ManyToOne
	@JoinColumn(name = "dispatcher_id")
	private Dispatcher dispatcher;

	@ManyToMany
	@JoinTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> products = new HashSet<>();

	public WorkOrder() {
	}

	public WorkOrder(Long id, Priority priority, Status status, String clientName, String clientAddress,
			String clientCity, String clientZip, String headline, String description, Manager manager,
			Dispatcher dispatcher) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientCity = clientCity;
		this.clientZip = clientZip;
		this.headline = headline;
		this.description = description;
		this.manager = manager;
		this.dispatcher = dispatcher;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientZip() {
		return clientZip;
	}

	public void setClientZip(String clientZip) {
		this.clientZip = clientZip;
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

	public Set<Product> getProducts() {
		return products;
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
