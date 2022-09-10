package com.wallacebp.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallacebp.dto.WorkOrderDTO;
import com.wallacebp.entities.Dispatcher;
import com.wallacebp.entities.Manager;
import com.wallacebp.entities.WorkOrder;
import com.wallacebp.enums.Priority;
import com.wallacebp.enums.Status;
import com.wallacebp.repositories.DispatcherRepository;
import com.wallacebp.repositories.ManagerRepository;
import com.wallacebp.repositories.WorkOrderRepository;
import com.wallacebp.services.exceptions.DatabaseException;
import com.wallacebp.services.exceptions.ResourceNotFoundException;

@Service
public class WorkOrderService {

	@Autowired
	private WorkOrderRepository repository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private DispatcherRepository dispatcherRepository;

	@Transactional(readOnly = true)
	public Page<WorkOrderDTO> findAllPaged(Pageable pageable) {
		Page<WorkOrder> list = repository.findAll(pageable);
		return list.map(x -> new WorkOrderDTO(x));
	}

	@Transactional(readOnly = true)
	public WorkOrderDTO findById(Long id) {
		Optional<WorkOrder> obj = repository.findById(id);
		WorkOrder entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found! id: " + id));
		return new WorkOrderDTO(entity);
	}

	@Transactional
	public WorkOrderDTO insert(WorkOrderDTO dto) {
		Manager manager = managerRepository.findById(dto.getManager()).get();
		Dispatcher dispatcher = dispatcherRepository.findById(dto.getDispatcher()).get();

		WorkOrder entity = new WorkOrder();
		if (dto.getId() != null) {
			entity.setId(dto.getId());
		}

		entity.setManager(manager);
		entity.setDispatcher(dispatcher);
		entity.setPriority(Priority.toEnum(dto.getPriority()));
		entity.setStatus(Status.toEnum(dto.getStatus()));
		entity.setHeadline(dto.getHeadline());
		entity.setDescription(dto.getDescription());
		entity.setClientAddress(dto.getClientAddress());
		entity.setClientName(dto.getClientName());
		entity = repository.save(entity);
		return new WorkOrderDTO(entity);
	}

	@Transactional
	public WorkOrderDTO update(Long id, WorkOrderDTO dto) {
		try {
			Manager manager = managerRepository.findById(dto.getManager()).get();
			Dispatcher dispatcher = dispatcherRepository.findById(dto.getDispatcher()).get();

			WorkOrder entity = repository.getById(id);
			entity.setManager(manager);
			entity.setDispatcher(dispatcher);
			entity.setPriority(Priority.toEnum(dto.getPriority()));
			entity.setStatus(Status.toEnum(dto.getStatus()));
			entity.setHeadline(dto.getHeadline());
			entity.setDescription(dto.getDescription());
			entity.setClientAddress(dto.getClientAddress());
			entity.setClientName(dto.getClientName());
			entity = repository.save(entity);
			return new WorkOrderDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation!");
		}
	}

}
