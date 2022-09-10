package com.wallacebp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wallacebp.entities.Admin;
import com.wallacebp.repositories.AdminRepository;
import com.wallacebp.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<Admin> user = repository.findByName(name);
		if (user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getName(), user.get().getPassword(), user.get().getProfiles());
		}
		throw new UsernameNotFoundException(name);
	}

}
