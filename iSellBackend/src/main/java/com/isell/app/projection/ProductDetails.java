package com.isell.app.projection;

public class ProductDetails {
	
	 int id;
	 String description;
	 String preparationTime;
	 double price;
	 String picture;
	 int serviceProvider;
	 int category;
	 String name;
	 String email;
	 String phone;
	 int city;
	 String logo;
	public ProductDetails(int id, String description, String preparationTime, double price, String picture,
			int serviceProvider, int category, String name, String email, String phone, int city, String logo) {
		super();
		this.id = id;
		this.description = description;
		this.preparationTime = preparationTime;
		this.price = price;
		this.picture = picture;
		this.serviceProvider = serviceProvider;
		this.category = category;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.logo = logo;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	 
}
