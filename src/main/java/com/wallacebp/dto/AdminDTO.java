package com.wallacebp.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.wallacebp.entities.Admin;

public class AdminDTO {

	private Long id;
	private String name;
	private String passwrod;
	private Set<Integer> profiles = new HashSet<>();

	public AdminDTO() {
	}

	public AdminDTO(Long id, String name, String passwrod, Set<Integer> profiles) {
		super();
		this.id = id;
		this.name = name;
		this.passwrod = passwrod;
		this.profiles = profiles;
	}

	public AdminDTO(Admin entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.passwrod = entity.getPassword();
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

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

}
