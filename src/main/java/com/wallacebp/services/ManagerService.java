package com.wallacebp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallacebp.dto.ManagerDTO;
import com.wallacebp.entities.Manager;
import com.wallacebp.entities.Person;
import com.wallacebp.repositories.ManagerRepository;
import com.wallacebp.repositories.PersonRepository;
import com.wallacebp.services.exceptions.DatabaseException;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional(readOnly = true)
	public List<ManagerDTO> findAll( ) {
		List<Manager> list = repository.findAll();
		return list.stream().map((x -> new ManagerDTO(x))).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ManagerDTO findById(Long id) {
		Optional<Manager> obj = repository.findById(id);
		Manager entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new ManagerDTO(entity);
	}

	@Transactional
	public ManagerDTO insert(ManagerDTO dto) {
		Manager entity = new Manager();
		isValid(dto);
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity = repository.save(entity);
		return new ManagerDTO(entity);
	}

	@Transactional
	public ManagerDTO update(Long id, ManagerDTO dto) {
		try {
			Manager entity = repository.getById(id);
			isValid(dto);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setPhoneNumber(dto.getPhoneNumber());
			entity = repository.save(entity);
			return new ManagerDTO(entity);
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
			throw new DatabaseException("The manager has orders and cannot be deleted!");
		}
	}
	
	
	private void isValid(ManagerDTO dto) {
		Optional<Person> person = personRepository.findByName(dto.getName());
		

		if (person.isPresent() && person.get().getId() != dto.getId()) {
			throw new DatabaseException("Name already registered!");
		}

	

	}

}
