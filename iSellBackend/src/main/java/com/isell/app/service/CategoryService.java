package com.isell.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isell.app.model.Category;
import com.isell.app.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Iterable<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getSingleCategory(Integer id) {
		
		return categoryRepository.findById(id);
	}
}
