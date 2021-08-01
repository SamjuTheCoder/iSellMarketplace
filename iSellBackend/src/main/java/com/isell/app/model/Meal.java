package com.isell.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String description;
	@Column
	private String preparationTime;
	@Column
	private double price;
	@Column
	private String picture;
	@Column
	private int serviceProvider;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceProvider", insertable=false, updatable=false,nullable = false)
    private ServiceProvider service;
	
	public Meal(int id, String description, String preparationTime, double price, String picture,
			int serviceProvider) {
		super();
		this.id = id;
		this.description = description;
		this.preparationTime = preparationTime;
		this.price = price;
		this.picture = picture;
		this.serviceProvider = serviceProvider;
	}
	
	public Meal() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(int serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	
}
