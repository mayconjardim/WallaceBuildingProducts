package com.wallacebp.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallacebp.dto.AdminDTO;
import com.wallacebp.entities.Admin;
import com.wallacebp.entities.Person;
import com.wallacebp.repositories.AdminRepository;
import com.wallacebp.repositories.PersonRepository;
import com.wallacebp.services.exceptions.DatabaseException;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired BCryptPasswordEncoder encoder;

	@Transactional(readOnly = true)
	public Page<AdminDTO> findAllPaged(Pageable pageable) {
		Page<Admin> list = repository.findAll(pageable);
		return list.map(x -> new AdminDTO(x));
	}

	@Transactional(readOnly = true)
	public AdminDTO findById(Long id) {
		Optional<Admin> obj = repository.findById(id);
		Admin entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new AdminDTO(entity);
	}

	@Transactional
	public AdminDTO insert(AdminDTO dto) {
		Admin entity = new Admin();
		isValid(dto);
		entity.setName(dto.getName());
		entity.setPassword(encoder.encode(dto.getPasswrod()));
		entity = repository.save(entity);
		return new AdminDTO(entity);
	}

	@Transactional
	public AdminDTO update(Long id, AdminDTO dto) {
		try {
			Admin entity = repository.getById(id);
			isValid(dto);
			entity.setName(dto.getName());
			entity.setPassword(encoder.encode(dto.getPasswrod()));
			entity = repository.save(entity);
			return new AdminDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e ) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
		catch (DataIntegrityViolationException e ) {
			throw new DatabaseException("Integrity Violation!");
		}
	}
	
	
	private void isValid(AdminDTO dto) {
		Optional<Person> person = personRepository.findByName(dto.getName());

		if (person.isPresent() && person.get().getId() != dto.getId()) {
			throw new DatabaseException("Name already registered!");
		}

	}

}
