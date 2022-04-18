package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Expense 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private Long id;
	
	public Expense()
	{
		// ******** -------- Constructor that does absolutely nothing -------- ********
	}
	
	@NotNull(message="Name cannot be blank")
	private String name;
	
	@NotNull(message="Please enter the vendor name")
	private String vendor;
	
	
	private Double price;
	
	@NotNull(message="Please give a brief description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
};