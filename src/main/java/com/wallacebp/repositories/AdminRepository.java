package com.wallacebp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacebp.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Admin> findByName(String name);
	
}
