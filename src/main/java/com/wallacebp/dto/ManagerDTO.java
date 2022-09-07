package com.wallacebp.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.wallacebp.entities.Manager;

public class ManagerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty
	private String name;

	@Email
	private String email;
	
	@NotEmpty
	private String phoneNumber;
	private Set<Integer> profiles = new HashSet<>();

	public ManagerDTO() {
	}

	public ManagerDTO(Long id, String name, String email, String phoneNumber, Set<Integer> profiles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.profiles = profiles;
	}

	public ManagerDTO(Manager entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phoneNumber = entity.getPhoneNumber();
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

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}
	
	

}
