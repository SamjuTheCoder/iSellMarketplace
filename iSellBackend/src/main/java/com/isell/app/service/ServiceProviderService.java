package com.isell.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isell.app.model.Meal;
import com.isell.app.model.ServiceProvider;
import com.isell.app.repository.ServiceProviderRepository;

@Service
public class ServiceProviderService {

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	public Iterable<ServiceProvider> getAllServiceProvider() {
		
		return serviceProviderRepository.findAll();
	}
	
	public Optional<ServiceProvider> findServiceById(Integer id) {
		
		return serviceProviderRepository.findById(id);
	}

	
}
