package com.wallacebp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallacebp.entities.Admin;
import com.wallacebp.entities.Dispatcher;
import com.wallacebp.entities.Manager;
import com.wallacebp.entities.WorkOrder;
import com.wallacebp.enums.Priority;
import com.wallacebp.enums.Status;
import com.wallacebp.repositories.AdminRepository;
import com.wallacebp.repositories.DispatcherRepository;
import com.wallacebp.repositories.ManagerRepository;
import com.wallacebp.repositories.WorkOrderRepository;

@Service
public class DBService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private DispatcherRepository dispatcherRepository;

	@Autowired
	private WorkOrderRepository orderRepository;

	public void instanciaDB() {

		Admin adm1 = new Admin(null, "Admin", "88471989");

		Manager mg1 = new Manager(null, "Tjeua", "tjeua@gmail.com", "+5521975185287");

		Dispatcher dp1 = new Dispatcher(null, "Doug");

		WorkOrder order1 = new WorkOrder(null, Priority.LOW, Status.OPEN, "Douglas Souza", "Avenida 12", "Chamado 1",
				"concertar pc", mg1, dp1);

		adminRepository.saveAll(Arrays.asList(adm1));
		managerRepository.saveAll(Arrays.asList(mg1));
		dispatcherRepository.saveAll(Arrays.asList(dp1));
		orderRepository.saveAll(Arrays.asList(order1));

	}

}
