package com.isell.app.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isell.app.model.Category;
import com.isell.app.model.City;
import com.isell.app.model.Meal;
import com.isell.app.model.ServiceProvider;
import com.isell.app.projection.ProductDetails;
import com.isell.app.service.CategoryService;
import com.isell.app.service.CityService;
import com.isell.app.service.MealService;
import com.isell.app.service.ServiceProviderService;

@RestController
public class RestfulController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CityService cityService;
	@Autowired
	private MealService mealService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@RequestMapping(value = {"/api/categories"}, produces = "application/json", method = RequestMethod.GET)
	public Iterable<Category> getCategory() {
		
		return categoryService.getAllCategory();
	}
	
	@RequestMapping(value = {"/api/singlecategory/{id}"}, method = RequestMethod.GET)
	public Optional<Category> getCategoryById(@PathVariable("id") Integer id) {
		
		return categoryService.getSingleCategory(id);
	}

	@RequestMapping(value = {"/api/city"}, method = RequestMethod.GET)
	public Iterable<City> getCity() {
		
		return cityService.getAllCity();
	}
	
	@RequestMapping(value = {"/api/serviceprovider"}, method = RequestMethod.GET)
	public Iterable<ServiceProvider> getServiceProvider() {
		
		return serviceProviderService.getAllServiceProvider();
	}
	
	@RequestMapping(value = {"/api/meal"}, method = RequestMethod.GET)
	public Iterable<Meal> getMeal() {
		
		return mealService.getAllMeal();
	}
	
	@RequestMapping(value = {"/api/service/{id}"}, method = RequestMethod.GET)
	public Optional<ServiceProvider> getServiceProviderById(@PathVariable("id") Integer id) {
		
		return serviceProviderService.findServiceById(id);
	}
	
	@RequestMapping(value = {"/api/productdetails/{id}"}, method = RequestMethod.GET)
	public ProductDetails getProductDetails(@PathVariable("id") Integer id) {
		
		return mealService.findProductById(id);
	}
	
	@RequestMapping(value = {"/api/listingbycategory/{id}"}, method = RequestMethod.GET)
	public Collection<ProductDetails> getProductDetailsByCategory(@PathVariable("id") Integer id) {
		
		return mealService.findProductByCategory(id);
	}
	
	@RequestMapping(value = {"/api/searchbycity/{category}/{city}"}, method = RequestMethod.GET)
	public Collection<ProductDetails> getProductDetailsByCity(@PathVariable("category") Integer category, @PathVariable("city") Integer city) {
		
		return mealService.findProductByCity(category, city);
	}
	
	@RequestMapping(value = {"/api/searchbyname/{name}"}, method = RequestMethod.GET)
	public Collection<ProductDetails> getProductDetailsByName(@PathVariable("name") String name) {
		
		return mealService.findProductByName(name);
	}
}
