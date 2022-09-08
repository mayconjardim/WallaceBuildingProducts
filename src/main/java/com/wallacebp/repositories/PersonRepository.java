package com.wallacebp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacebp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Optional<Person> findByName(String name);
	
}
