package com.hoppersreceipt;

public class Item 
{
	private String name;
	private String itemName;
	private Double price;
	private String description;
	private String vendor;
	
	public Item()
	{
		this.setName("");
		this.setItemName("");
		this.setPrice(0.00);
		this.setDescription("");
		this.setVendor("");
	}
	
	public Item(String name, String itemName, Double price, String description, String vendor)
	{
		this.setName(name);
		this.setItemName(itemName);
		this.setPrice(price);
		this.setDescription(description);
		this.setVendor(vendor);
				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
