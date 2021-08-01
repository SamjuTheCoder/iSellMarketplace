package com.isell.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class ServiceProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int category;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private int city;
	@Column
	private String logo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Meal> meal;
	
	public ServiceProvider(int id, int category, String name, String email, String phone, int city, String logo) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.logo = logo;
	}
	
	public ServiceProvider() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
