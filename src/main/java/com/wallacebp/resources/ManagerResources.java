package com.wallacebp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallacebp.dto.ManagerDTO;
import com.wallacebp.services.ManagerService;

@RestController
@RequestMapping(value = "/managers")
public class ManagerResources {

	@Autowired
	private ManagerService service;
	
	@GetMapping
	public ResponseEntity<Page<ManagerDTO>> findAll(Pageable pageable){
		Page<ManagerDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ManagerDTO> findById(@PathVariable Long id){
		ManagerDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
