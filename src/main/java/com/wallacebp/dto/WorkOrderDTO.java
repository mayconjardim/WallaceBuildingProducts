package com.wallacebp.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wallacebp.entities.WorkOrder;

public class WorkOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate startDate = LocalDate.now();

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate endDate;
	@NotNull(message = "Priority cannot be empty.")
	private Integer priority;
	@NotNull(message = "Status cannot be empty.")
	private Integer status;
	@NotNull(message = "Client Name cannot be empty.")
	private String clientName;
	@NotNull(message = "Client Address cannot be empty.")
	private String clientAddress;
	@NotNull(message = "Client City cannot be empty.")
	private String clientCity;
	@NotNull(message = "Client Zip cannot be empty.")
	private String clientZip;
	@NotNull(message = "Headline cannot be empty.")
	private String headline;
	@NotNull(message = "Description cannot be empty.")
	private String description;
	@NotNull(message = "Dispatcher cannot be empty.")
	private Long dispatcher;
	@NotNull(message = "Manager cannot be empty.")
	private Long manager;
	private String nameDispatcher;
	private String nameManager;

	public WorkOrderDTO() {
	}

	public WorkOrderDTO(WorkOrder entity) {
		super();
		this.id = entity.getId();
		this.startDate = entity.getStartDate();
		this.endDate = entity.getEndDate();
		this.priority = entity.getPriority().getCod();
		this.status = entity.getStatus().getCod();
		this.clientName = entity.getClientName();
		this.clientAddress = entity.getClientAddress();
		this.headline = entity.getHeadline();
		this.description = entity.getDescription();
		this.dispatcher = entity.getDispatcher().getId();
		this.manager = entity.getManager().getId();
		this.nameDispatcher = entity.getDispatcher().getName();
		this.nameManager = entity.getManager().getName();
		this.clientCity = entity.getClientCity();
		this.clientZip = entity.getClientZip();
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Long getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Long dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Long getManager() {
		return manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}

	public String getNameDispatcher() {
		return nameDispatcher;
	}

	public void setNameDispatcher(String nameDispatcher) {
		this.nameDispatcher = nameDispatcher;
	}

	public String getNameManager() {
		return nameManager;
	}

	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
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

}
