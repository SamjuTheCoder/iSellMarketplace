package com.isell.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isell.app.model.Meal;
import com.isell.app.projection.ProductDetails;
import com.isell.app.repository.MealRepository;

@Service
public class MealService {

	@Autowired
	private MealRepository mealRepository;
	
	public Iterable<Meal> getAllMeal() {
		return mealRepository.findAll();
	}
	
	public ProductDetails findProductById(Integer id) {
		return (ProductDetails) mealRepository.findMealById(id);
	}
	
	public Collection<ProductDetails> findProductByCategory(Integer id) {
		return (Collection<ProductDetails>) mealRepository.findMealByCategory(id);
	}
	
	public Collection<ProductDetails> findProductByCity(Integer category, Integer city) {
		return (Collection<ProductDetails>) mealRepository.findMealByCity(category, city);
	}
	
	public Collection<ProductDetails> findProductByName(String name) {
		return (Collection<ProductDetails>) mealRepository.findMealByName(name);
	}
}
