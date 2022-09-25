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

import com.wallacebp.dto.ProductDTO;
import com.wallacebp.entities.Person;
import com.wallacebp.entities.Product;
import com.wallacebp.repositories.PersonRepository;
import com.wallacebp.repositories.ProductRepository;
import com.wallacebp.services.exceptions.DatabaseException;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll( ) {
		List<Product> list = repository.findAll();
		return list.stream().map((x -> new ProductDTO(x))).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		isValid(dto);
		entity.setName(dto.getName());
		entity.setStock(dto.getStock());
		entity.setQuantity(dto.getQuantity());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getById(id);
			isValid(dto);
			entity.setName(dto.getName());
			entity.setStock(dto.getStock());
			entity.setQuantity(dto.getQuantity());
			entity = repository.save(entity);
			return new ProductDTO(entity);
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
	
	
	private void isValid(ProductDTO dto) {
		Optional<Person> person = personRepository.findByName(dto.getName());

		if (person.isPresent() && person.get().getId() != dto.getId()) {
			throw new DatabaseException("Name already registered!");
		}

	}

}
