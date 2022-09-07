package com.wallacebp.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallacebp.dto.ManagerDTO;
import com.wallacebp.entities.Manager;
import com.wallacebp.repositories.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ManagerDTO> findAllPaged(Pageable pageable){
		Page<Manager> list = repository.findAll(pageable);
		return list.map(x -> new ManagerDTO(x));
	}
	
}
