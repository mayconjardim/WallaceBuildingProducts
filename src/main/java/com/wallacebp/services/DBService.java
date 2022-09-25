package com.wallacebp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wallacebp.entities.Admin;
import com.wallacebp.entities.Dispatcher;
import com.wallacebp.entities.Manager;
import com.wallacebp.entities.Product;
import com.wallacebp.repositories.AdminRepository;
import com.wallacebp.repositories.DispatcherRepository;
import com.wallacebp.repositories.ManagerRepository;
import com.wallacebp.repositories.ProductRepository;

@Service
public class DBService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private DispatcherRepository dispatcherRepository;


	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired BCryptPasswordEncoder encoder;

	public void instanciaDb() {

		Admin adm = new Admin(null, "Admin", encoder.encode("123"));
			
		Product prod = new Product(null, "Veneer Mdf Door Skin Panel", 100, 0);
		Product prod1 = new Product(null, "Waterproof 3/4 1/2 Pine Cdx Plywood 4x8", 80, 0);
		Product prod2 = new Product(null, "12mm Black Film Finger Joint Core Plywood Formwork", 50, 0);
		Product prod3 = new Product(null, "High Quality 1.5mm Natural Birch Veneer", 100, 0);
		Product prod4 = new Product(null, "Construction Grade Pine CDX Plywood", 77, 0);
		Product prod5 = new Product(null, "1220*2440 Fire Retardent HPL Laminate Plywood", 84, 0);
		Product prod6 = new Product(null, "Birch Plywood With BB/BP Grade E0 Glue", 92, 0);
		Product prod7 = new Product(null, "High Quality Laminated MDF Board", 15, 0);
		Product prod8 = new Product(null, "Moisture-proof Green MDF", 18, 0);
		Product prod9 = new Product(null, "Natural Veneer Moulded HDF Door Skin Panels", 68, 0);
		Product prod10 = new Product(null, "Melamine Mdf Price For Decoration", 74, 0);
		Product prod11 = new Product(null, "Melamine White 15mm Mdf", 68, 0);
		Product prod12 = new Product(null, "Melamine Faced Particle Board for Furniture", 25, 0);
		Product prod13 = new Product(null, "Matte Finish Particle Melamine Board", 35, 0);
		Product prod14 = new Product(null, "6mm Plastic Tiles Vinyl Plank Spc Flooring", 37, 0);
		Product prod15 = new Product(null, "4mm 5mm 6mm Click Lock Rigid Spc Flooring Waterproof ", 88, 0);
			
		
		Manager mg1 = new Manager(null, "Rodrigo Tjeua", "tjeua@wallacebp.com", "+1(617)501-0735");
		Manager mg2 = new Manager(null, "Greg Lloyd", "lloyd@wallacebp.com", "+1(145)872-4219");
		Manager mg3 = new Manager(null, "Chris Fields", "fields@wallacebp.com", "+1(617)501-0735");
		Manager mg4 = new Manager(null, "Bobbie Jordan", "jordan@wallacebp.com", "+1(620)522-2424");
		Manager mg5 = new Manager(null, "Damon Edwards", "edwards@wallacebp.com", "+1(550)234-3838");
		Manager mg6 = new Manager(null, "Lance South", "south@wallacebp.com", "+1(145)872-4219");
		Manager mg7 = new Manager(null, "Brent Smith", "smith@wallacebp.com", "+1(617)501-0735");
		Manager mg8 = new Manager(null, "Kurt Murray", "murray@wallacebp.com", "+1(620)522-2424");
		Manager mg9 = new Manager(null, "Ben Fox", "fox@wallacebp.com", "+1(550)234-3838");
		Manager mg10 = new Manager(null, "Benjamin Apollo", "apollo@wallacebp.com", "+1(145)872-4219");

		Dispatcher dp1 = new Dispatcher(null, "Grant Thompson");
		Dispatcher dp2 = new Dispatcher(null, "Billie Phoenix");
		Dispatcher dp3 = new Dispatcher(null, "Karl Strong");
		Dispatcher dp4 = new Dispatcher(null, "Karl Strong");
		Dispatcher dp5 = new Dispatcher(null, "Alec Dusk");
		Dispatcher dp6 = new Dispatcher(null, "Glen Strong");
		Dispatcher dp7 = new Dispatcher(null, "Hognny Wolf");
		Dispatcher dp8 = new Dispatcher(null, "Justin Ray");
		Dispatcher dp9 = new Dispatcher(null, "Charles Neptune");
		Dispatcher dp10 = new Dispatcher(null, "Bradley Child");

		
		
		

		
		adminRepository.saveAll(Arrays.asList(adm));
		
		productRepository.saveAll(Arrays.asList(prod, prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9,
				prod10, prod11, prod12, prod13, prod14, prod15));
	
		managerRepository.saveAll(Arrays.asList(mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10));
		
		dispatcherRepository.saveAll(Arrays.asList(dp1, dp2, dp3, dp4, dp5, dp6, dp7, dp8, dp9, dp10));
		
		
		
		
	}

}
