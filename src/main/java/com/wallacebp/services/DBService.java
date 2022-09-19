package com.wallacebp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired BCryptPasswordEncoder encoder;

	public void instanciaDb() {

		
		Admin adm1 = new Admin(null, "Admin", encoder.encode("123"));
		Admin adm2 = new Admin(null, "Super", encoder.encode("123"));
		
		Manager mg1 = new Manager(null, "Rodrigo Tjeua", "tjeua@gmail.com", "+1(617)501-0735");
		Manager mg2 = new Manager(null, "LeBron James", "lebron@gmail.com", "+1(620)522-2424");
		Manager mg3 = new Manager(null, "Jason Tatum", "tatum@gmail.com", "+1(550)234-3838");
		Manager mg4 = new Manager(null, "Kevin Durant", "kevin@gmail.com", "+1(145)872-4219");

		Dispatcher dp1 = new Dispatcher(null, "Nikola Jokic");
		Dispatcher dp2 = new Dispatcher(null, "James Harden");
		Dispatcher dp3 = new Dispatcher(null, "Joel Embiid");
		Dispatcher dp4 = new Dispatcher(null, "Luka Doncic");

		
		WorkOrder order1 = new WorkOrder(null, Priority.LOW, Status.OPEN, "Los Angeles Lakers", "Stapes Center", "Street 114", "Los Angeles", "113", "Vasco", mg1, dp1);

		adminRepository.saveAll(Arrays.asList(adm1, adm2));
		managerRepository.saveAll(Arrays.asList(mg1, mg2, mg3, mg4));
		dispatcherRepository.saveAll(Arrays.asList(dp1, dp2, dp3, dp4));
		orderRepository.saveAll(Arrays.asList(order1));
		
		
	}

}
