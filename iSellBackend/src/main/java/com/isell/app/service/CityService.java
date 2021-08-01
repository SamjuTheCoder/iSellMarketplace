package com.isell.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isell.app.model.City;
import com.isell.app.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public Iterable<City> getAllCity() {
		return cityRepository.findAll();
	}
}
