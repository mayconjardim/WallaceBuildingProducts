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

import com.wallacebp.dto.DispatcherDTO;
import com.wallacebp.entities.Dispatcher;
import com.wallacebp.entities.Person;
import com.wallacebp.repositories.DispatcherRepository;
import com.wallacebp.repositories.PersonRepository;
import com.wallacebp.services.exceptions.DatabaseException;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class DispatcherService {

	@Autowired
	private DispatcherRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional(readOnly = true)
	public List<DispatcherDTO> findAll( ) {
		List<Dispatcher> list = repository.findAll();
		return list.stream().map((x -> new DispatcherDTO(x))).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public DispatcherDTO findById(Long id) {
		Optional<Dispatcher> obj = repository.findById(id);
		Dispatcher entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new DispatcherDTO(entity);
	}

	@Transactional
	public DispatcherDTO insert(DispatcherDTO dto) {
		Dispatcher entity = new Dispatcher();
		isValid(dto);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new DispatcherDTO(entity);
	}

	@Transactional
	public DispatcherDTO update(Long id, DispatcherDTO dto) {
		try {
			Dispatcher entity = repository.getById(id);
			isValid(dto);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new DispatcherDTO(entity);
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
			throw new DatabaseException("The dispatcher has orders and cannot be deleted!");
		}
	}
	
	
	private void isValid(DispatcherDTO dto) {
		Optional<Person> person = personRepository.findByName(dto.getName());

		if (person.isPresent() && person.get().getId() != dto.getId()) {
			throw new DatabaseException("Name already registered!");
		}

	}

}
