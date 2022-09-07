package com.wallacebp.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallacebp.dto.ManagerDTO;
import com.wallacebp.entities.Manager;
import com.wallacebp.repositories.ManagerRepository;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ManagerDTO> findAllPaged(Pageable pageable){
		Page<Manager> list = repository.findAll(pageable);
		return list.map(x -> new ManagerDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ManagerDTO findById(Long id) {
		Optional<Manager> obj = repository.findById(id);
		Manager entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new ManagerDTO(entity);
	}
	
}
