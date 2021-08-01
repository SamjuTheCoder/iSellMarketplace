package com.isell.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isell.app.model.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProvider, Integer> {

	//public ServiceProvider findById(Integer id);
}
