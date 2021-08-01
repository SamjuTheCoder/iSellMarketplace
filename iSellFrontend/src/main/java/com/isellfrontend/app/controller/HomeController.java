package com.isellfrontend.app.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String GET_ALL_CATEGORIES = "http://localhost:8081/api/categories";
	private static final String GET_ALL_CITY = "http://localhost:8081/api/city";
	private static final String GET_ALL_MEAL = "http://localhost:8081/api/meal";
	private static final String GET_ALL_SERVICE_PROVIDER = "http://localhost:8081/api/serviceprovider";
	private static final String GET_PRODUCT_DETAIL = "http://localhost:8081/api/productdetails/";
	private static final String GET_PRODUCT_DETAIL_CATEGORY = "http://localhost:8081/api/listingbycategory/";
	private static final String GET_PRODUCT_DETAIL_CITY = "http://localhost:8081/api/searchbycity/";
	private static final String GET_PRODUCT_DETAIL_NAME = "http://localhost:8081/api/searchbyname/";
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model= new ModelAndView();
		
		Object[] category = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		Object[] city = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 
		Object[] meal = restTemplate.getForObject(GET_ALL_MEAL, Object[].class); 
		Object[] serviceprovider = restTemplate.getForObject(GET_ALL_SERVICE_PROVIDER, Object[].class); 
		
		model.addObject("category", Arrays.asList(category));
		model.addObject("location", Arrays.asList(city));
		model.addObject("products", Arrays.asList(meal));
		model.addObject("serviceprovider", Arrays.asList(serviceprovider));
		
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = {"/product-details/{id}"}, method = RequestMethod.GET)
	public ModelAndView productDetails(@PathVariable("id") Integer id) {
		ModelAndView model= new ModelAndView();
		Object[] city = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 		
		Object product_detail = restTemplate.getForObject(GET_PRODUCT_DETAIL+id, Object.class);
		Object[] category = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		
		model.addObject("details", product_detail);
		model.addObject("location", Arrays.asList(city));
		model.addObject("category", Arrays.asList(category));
		model.setViewName("food-details");
		
		return model;
	}
	
	@RequestMapping(value = {"/more-details/{id}"}, method = RequestMethod.GET)
	public ModelAndView productDetailsByCategory(@PathVariable("id") Integer id) {
		ModelAndView model= new ModelAndView();
		Object[] city = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 		
		Object[] category = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		Object[] productByCategory = restTemplate.getForObject(GET_PRODUCT_DETAIL_CATEGORY+id, Object[].class);
		
		model.addObject("details", Arrays.asList(productByCategory));
		model.addObject("location", Arrays.asList(city));
		model.addObject("category", Arrays.asList(category));
		model.addObject("name", id);
		model.setViewName("product-listing");
		
		return model;
	}
	
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	public ModelAndView productDetailsByCity(@RequestParam(name="category", defaultValue = "") Integer category, @RequestParam(name="city", defaultValue = "") Integer city) {
		ModelAndView model= new ModelAndView();
		Object[] cities = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 		
		Object[] categories = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		Object[] productByCity = restTemplate.getForObject(GET_PRODUCT_DETAIL_CITY+category+'/'+city, Object[].class);
		
		model.addObject("details", Arrays.asList(productByCity));
		model.addObject("location", Arrays.asList(cities));
		model.addObject("category", Arrays.asList(categories));
		
		model.setViewName("search-listing");
		
		return model;
	}
	
	@RequestMapping(value = {"/place-order"}, method = RequestMethod.POST)
	public ModelAndView placeOrder(@RequestParam(name="id", defaultValue = "") Integer id) {
		ModelAndView model= new ModelAndView();
		Object[] cities = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 		
		Object[] categories = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		Object product_detail = restTemplate.getForObject(GET_PRODUCT_DETAIL+id, Object.class);
		
		model.addObject("details", product_detail);
		model.addObject("location", Arrays.asList(cities));
		model.addObject("category", Arrays.asList(categories));
		
		model.setViewName("place-order");
		
		return model;
	}
	
	@RequestMapping(value = {"/meal/{name}"}, method = RequestMethod.GET)
	public ModelAndView getMealByName(@PathVariable("name") String name) {
		ModelAndView model= new ModelAndView();
		Object[] cities = restTemplate.getForObject(GET_ALL_CITY, Object[].class); 		
		Object[] categories = restTemplate.getForObject(GET_ALL_CATEGORIES, Object[].class);
		Object[] product_detail = restTemplate.getForObject(GET_PRODUCT_DETAIL_NAME+name, Object[].class);
		
		model.addObject("details", Arrays.asList(product_detail));
		model.addObject("location", Arrays.asList(cities));
		model.addObject("category", Arrays.asList(categories));
		model.addObject("name", name);
		
		model.setViewName("meal");
		
		return model;
	}
	
	@RequestMapping(value = {"/about-us"}, method = RequestMethod.GET)
	public ModelAndView aboutUs() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("about-us");
		return model;
	}
	
	@RequestMapping(value = {"/contact-us"}, method = RequestMethod.GET)
	public ModelAndView contactUs() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("contact-us");
		return model;
	}
}
