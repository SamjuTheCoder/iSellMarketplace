package com.isell.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isell.app.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
