package com.wallacebp.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import com.wallacebp.entities.Dispatcher;

public class DispatcherDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private String name;

	private Set<Integer> profiles = new HashSet<>();

	public DispatcherDTO() {
	}

	public DispatcherDTO(Long id, @NotEmpty String name, Set<Integer> profiles) {
		super();
		this.id = id;
		this.name = name;
		this.profiles = profiles;
	}

	public DispatcherDTO(Dispatcher entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.profiles = entity.getProfiles().stream().map(x -> x.getCod()).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

}
