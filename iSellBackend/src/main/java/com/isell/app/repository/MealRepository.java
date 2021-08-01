package com.isell.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isell.app.model.Meal;
import com.isell.app.projection.ProductDetails;

@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {

	@Query("SELECT new com.isell.app.projection.ProductDetails(c.id,c.description,c.preparationTime, c.price, c.picture, c.serviceProvider,t.category,t.name,t.email,t.phone,t.city,t.logo) FROM Meal AS c JOIN c.service AS t WHERE c.id = ?1")
	public ProductDetails findMealById(@Param("id") Integer id);
	
	@Query("SELECT new com.isell.app.projection.ProductDetails(c.id,c.description,c.preparationTime, c.price, c.picture, c.serviceProvider,t.category,t.name,t.email,t.phone,t.city,t.logo) FROM Meal AS c JOIN c.service AS t WHERE t.category = ?1")
	public Collection<ProductDetails> findMealByCategory(@Param("id") Integer id);
	
	@Query("SELECT new com.isell.app.projection.ProductDetails(c.id,c.description,c.preparationTime, c.price, c.picture, c.serviceProvider,t.category,t.name,t.email,t.phone,t.city,t.logo) FROM Meal AS c JOIN c.service AS t WHERE t.category = ?1 AND t.city = ?2")
	public Collection<ProductDetails> findMealByCity(@Param("category") Integer category, @Param("city") Integer city );
	
	@Query("SELECT new com.isell.app.projection.ProductDetails(c.id,c.description,c.preparationTime, c.price, c.picture, c.serviceProvider,t.category,t.name,t.email,t.phone,t.city,t.logo) FROM Meal AS c JOIN c.service AS t WHERE t.name = ?1")
	public Collection<ProductDetails> findMealByName(@Param("name") String name);
	
}
